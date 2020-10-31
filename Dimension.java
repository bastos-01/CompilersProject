import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.antlr.v4.runtime.ParserRuleContext;
public class Dimension extends Type{
	/*
	Dimension works out a new data Type
	name is the Dimension name, like Length for example
	unit corresponds to the  the initial unit that was associated with the dimension
	primtype corresponds to the primitive type of data associated with this dimension (real or integer)
	*/
	private String primtype;
	private List <String> units = new ArrayList<String>(); //the units of the Dimension
	public Map<String,String> conversions = new HashMap <String,String>();//In case it's added more units, we need to convert them to the first unit added;
	public Dimension(String name){
		super(name);
	}
	public Dimension(String name, String primtype, String unit){
		 super(name);
		 assert primtype!=null;
		 assert unit!=null;
		 this.primtype=primtype;
		 this.units.add(unit);
		 this.conversions.put(unit,"-1.0"); //quick way to find out the first unit added, so that we can convert every unit to the first created
	}
	
	//check if Dimension is numeric
	@Override
	public boolean isNumeric(){
		return (this.primtype.equals("integer") || this.primtype.equals("real"));
	}


	//add conversion
	public boolean addConversion(String unit, String formula){
		if(conversions.get(unit) !=null &&  conversions.get(unit).equals("-1.0")){ //comparam nova unidade em relaçao a unidade base
			if(checkUnit(unit)){
				units.add(unit);
			}
			conversions.put(unit,"-1.0");
			return true;
		} 
		else{  //comparar nova unidade em relaçao a unidade criada por utilizador
			if(checkUnit(unit)){
				units.add(unit);
			}
			conversions.put(unit,formula);
			return true;
		}
	}

//check formula 
public boolean checkFormula(ParserRuleContext ctx,String [] polynomial){
	Boolean val=true;
	if(polynomial.length > 2) {
		ErrorHandling.printError(ctx, "You can only have two members to assign to a new unit" );
		val=false;
	}
	int unitcounter=0;
	for(int i = 0; i< polynomial.length;i++){
	
		if(polynomial[i].substring(1, polynomial[i].length()-1).matches("-?\\d+(\\.\\d+)?")){ 
			continue;
		}
		else{
			unitcounter++;
			if (unitcounter>1 ){
				ErrorHandling.printError(ctx, "You can only have one unit to define new unit" );
				val=false;
			}
			String []sep = polynomial[i].split("\\*");
			String unit = "";
			unit=sep[1];
			if(checkUnit(unit)){
				ErrorHandling.printError(ctx, "Unit \"" + unit + "\" not found for this Dimension! "  );
				val=false;
			}
			
		}
	 }
	if (unitcounter == 0 ){
		ErrorHandling.printError(ctx, " Cannot add a unit without specifying a unit of this Dimension to compare with"  );
		val=false;
	} 
	return val;
}


 
//inverse the formula in order to do the correct conversion;
	public double calcConversion( String uni, double valuetoconvert){
		if (conversions.get(uni) == "-1.0") return 1*valuetoconvert;
		String []polynomial = conversions.get(uni).split("\\|");
		double  calc=0;
		double multiplier=0;
		Boolean val = true;
		List<Double> stackmonomial = new ArrayList<>();
		double tempcalc=0.0;
		for(int i = 0; i<polynomial.length;i++){
			if(polynomial[i].substring(1, polynomial[i].length()-1).matches("-?\\d+(\\.\\d+)?")){ 
				stackmonomial.add(Double.parseDouble(polynomial[i]));
			}
			else{
				String []sep = polynomial[i].split("\\*");
				String unit = "";
				unit=sep[1];
				if(conversions.get(unit).equals("-1.0")) multiplier=1;
				else{
					multiplier=calcConversion(unit,1);
				}
				Double temp =Double.parseDouble(sep[0]);
				tempcalc= multiplier / temp;
				
			}
		 }
		 for(int i = 0; i < stackmonomial.size();i++){
			 valuetoconvert-=stackmonomial.get(i);
		 }
		 valuetoconvert=tempcalc*valuetoconvert;
		 return valuetoconvert;
	} 

	// check if a unit is defined for this Dimension
	public boolean checkUnit(String unit){
		for(int i = 0; i< units.size();i++){
			if(units.get(i).equals(unit)) return false;
		}
		return true;
	}
	public String name(){
		return this.name;
	}

	public List<String> getUnits(){
		return this.units;
	}

	public String getBaseUnit() {
		for (String s : units) {
			if (conversions.get(s) == "-1.0") {
				return s;
			}
		}
		return null;
	}

	public String getPrimType(){
		return this.primtype;
	}

	@Override
	public boolean conformsTo(Type other) {
		boolean validation;
		if(!other.getClass().getName().equals("Dimension")){
			validation = (super.conformsTo(other) || this.primtype.equals(other.name()));
		}
		else{
			Dimension d = (Dimension) other;
			validation = (super.conformsTo(other) || this.primtype.equals(d.getPrimType()));
		}
      return validation;
   }

   public String toString()
   {
      return "" + this.name;
   }
 
}


