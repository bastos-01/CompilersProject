import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Map;
import java.io.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


import org.antlr.v4.runtime.ParserRuleContext;

/*
   Main visitor
*/

public class MainGramCheck extends MainGramBaseVisitor<Boolean> {
   private final RealType realType = new RealType();
   private final IntegerType integerType = new IntegerType();
   private final BooleanType booleanType = new BooleanType();
   private final StringType stringType = new StringType();
   private  boolean isinput=false;
   private Type fecthType(Type t1,Type t2,String op){
      Type r = null;
      if(t1.isNumeric() && t2.isNumeric()){
         if(t1.name().equals("real") || t2.name().equals("real")){
            r=realType;
         }
         else{
            r=t1;
         }
      }  
       else if (t1.name().equals("string")|| t2.name().equals("string") && op.equals("+") ){
          r=stringType;
       }
       return r;
   }

   //
   @Override
   public Boolean visitMain(MainGramParser.MainContext ctx) {
      Boolean validation=true;
      
      if(ctx.importDims()!=null){
         Iterator<MainGramParser.ImportDimsContext> it = ctx.importDims().iterator();       
         while(it.hasNext()){
            validation = visit(it.next());
         }
      }
      if(validation){
         if(ctx.statList().stat() !=null){
            validation= visit(ctx.statList());
         }
          
      }
     
     return validation;
   }
      

   @Override
   public Boolean visitStatList(MainGramParser.StatListContext ctx) {
      Iterator <MainGramParser.StatContext> iter = ctx.stat().iterator();
      Boolean res=true;
      while(iter.hasNext()){
         res=visit(iter.next());
      }

      return res;
   }

   @Override
   public Boolean visitStat(MainGramParser.StatContext ctx) {
      return visitChildren(ctx);
   }
   
   @Override
   public Boolean visitPrint(MainGramParser.PrintContext ctx) {
      boolean validation=visit(ctx.expr());
      return validation;
   }

   @Override
   public Boolean visitImportDimensionFile(MainGramParser.ImportDimensionFileContext ctx) {
      Boolean validation = true;
      String fileName = ctx.ID().getText()+".txt";
      InputStream in_stream = null;
      CharStream input = null;
      try {
         in_stream = new FileInputStream(new File(fileName));
         //instead of reading from user input, reads from file input
         input = CharStreams.fromStream(in_stream);
      } catch (IOException e) {
         ErrorHandling.printError(ctx, "ERROR: reading file \"" + fileName + "\"");
         validation = false;
      }
      if (validation) {
         DimensionsLexer lexer = new DimensionsLexer(input);
         CommonTokenStream tokens = new CommonTokenStream(lexer);
         DimensionsParser parser = new DimensionsParser(tokens);
         ParseTree tree = parser.program();

         if (parser.getNumberOfSyntaxErrors() == 0) {
         DimCheck visitor1 = new DimCheck();
         visitor1.visit(tree);
         }

    }
    return validation;
   }
   
   @Override
   public Boolean visitDecAssign(MainGramParser.DecAssignContext ctx) {
     Boolean validation =  visit(ctx.expr());
      String unit="";
      if (validation) {
         for (TerminalNode t : ctx.declaration().idList().ID()) {
            String id = t.getText();
            if (MainGramParser.symbolTable.containsKey(id)) {
               ErrorHandling.printError(ctx, "Variable \"" + id + "\" already defined ");
               validation = false;
            } else {
               
               validation = visit(ctx.declaration().type());
               if (validation){
               Type tp = ctx.declaration().type().res; 
               if (tp.getClass().getName().equals("Dimension")) {
                  if (ctx.expr().uni != null && !ctx.expr().uni.equals("noUnit")) {
                     unit = ctx.expr().uni.replace("(", "").replace(")", "");
                     Dimension dim = (Dimension) tp; // dimension is a type
                     if (dim.checkUnit(unit)) { // check if unit is in the list of units of Dimension
                        ErrorHandling.printError(ctx,"The unit \"" + unit + "\" is not allowed for dimension " + dim.name());
                        validation = false;
                     }
                     for (Dimension d : DimensionsParser.dimTable.values()){
                        for(int i = 0; i< d.getUnits().size();i++){
                           if(d.getUnits().get(i).equals(unit)){
                              unit=d.getBaseUnit();
                           }
                        }
                     }
                  } 
                  else if (!isinput) {
                     ErrorHandling.printError(ctx, "You must indicate the unit for Type \"" + tp + "\" .");
                  }
               }
               
               if (!tp.conformsTo(ctx.expr().eType)) {
                  ErrorHandling.printError(ctx, "Variable \"" + id + "\" type does not match to expression ");
                  validation = false;
               } else {
                  Symbol sb = new Symbol(id, tp);
                  if (tp.getClass().getName().equals("Dimension")) {
                     sb.setDim(ctx.declaration().type().getText());
                     sb.setUnit(unit);
                  }
                  sb.setValueDefined();
                  MainGramParser.symbolTable.put(id, sb);
               }
            }
            }
            isinput=false;
         }

      }
     
      return validation;
   }



   @Override
   public Boolean visitAssign(MainGramParser.AssignContext ctx) {
     boolean validation =  visit(ctx.expr());
      if (validation) {
         String id = ctx.ID().getText();
         if (!MainGramParser.symbolTable.containsKey(id)) {
            ErrorHandling.printError(ctx, "Variable \"" + id + "\" not defined ");
            validation = false;
         } else {
            Symbol sb = MainGramParser.symbolTable.get(id);
            if (sb.type().getClass().getName().equals("Dimension")) {
               if (ctx.expr().uni != null && !ctx.expr().uni.equals("noUnit")) {
                  String unit = ctx.expr().uni;
                  Dimension dim = (Dimension) sb.type(); // dimension is a type
                  if (dim.checkUnit(unit)) { // check if unit is in the list of units of Dimension
                     ErrorHandling.printError(ctx, "The unit \"" + unit + "\" is not allowed for dimension " + dim.name());
                     validation = false;
                  }
               } else if(!isinput) {
                  ErrorHandling.printError(ctx, "You must indicate the unit for Type \"" + sb.type() + "\" .");
               }
            }
            if (!sb.type().conformsTo(ctx.expr().eType)) {
               ErrorHandling.printError(ctx, "Variable \"" + id + "\" type does not match to expression ");
               validation = false;
            } else {
               if (sb.type().getClass().getName().equals("Dimension")) {
                  sb.setDim(ctx.expr().dim);
                  sb.setUnit(ctx.expr().uni);
               }
               sb.setValueDefined();

            }
         }
      
      }
      isinput=true;
      return validation;
   }

   @Override
   public Boolean visitDeclaration(MainGramParser.DeclarationContext ctx) {
      boolean validation=true;
      for (TerminalNode t : ctx.idList().ID()){
      String id = t.getText(), typeStr = ctx.type().getText();
      if (MainGramParser.symbolTable.containsKey(id)) {
         ErrorHandling.printError(ctx, "Variable \"" + id + "\" already defined");
        validation=false;
      } else {
         Boolean res =  visit(ctx.type());
         if (res) {
            Type type = ctx.type().res;
            Symbol s = new Symbol(typeStr, type);
            MainGramParser.symbolTable.put(id, s);
         }
      }
   }
      return validation;
   }


   @Override
   public Boolean visitConditional(MainGramParser.ConditionalContext ctx) {
      boolean validation =  visit(ctx.expr());

      if (validation) {
         if (ctx.expr().eType.conformsTo(booleanType)) {
           
            visit(ctx.trueSL);
            ctx.expr().uni = "noUnit";
            ctx.expr().dim = "noDim";
            ctx.expr().eType=booleanType;
            if (ctx.falseSL != null) {

               // if it enter else / else if statement..
               visit(ctx.falseSL);
            }
         } 
         else {
            ErrorHandling.printError(ctx, " Not a valid conditional expression for an if statement");
            validation = false;
         }
      }
     
      return validation;
   }

   @Override
   public Boolean visitElseif(MainGramParser.ElseifContext ctx) {
      return visitChildren(ctx);
   }

   @Override
   public Boolean visitForCond(MainGramParser.ForCondContext ctx) {
     Boolean validation =  visit(ctx.assignment());
      if (validation) {
         validation =  visit(ctx.expr(0)) &&  visit(ctx.expr(1)) &&  visit(ctx.trueSL);
         if (validation) {
            if (!ctx.expr(0).eType.conformsTo(booleanType)) {
               ErrorHandling.printError(ctx, "Not a valid conditional expression in a for statement");
               validation = false;
            }
            if (!ctx.expr(1).eType.isNumeric()) {
               ErrorHandling.printError(ctx, "Increment expression must be a numeric expression");
               validation = false;
            }
         }
      }
      return validation;
   }

   @Override
   public Boolean visitWhileCond(MainGramParser.WhileCondContext ctx) {
    Boolean  validation =  visit(ctx.expr());
      if (validation) {
         if (!ctx.expr().eType.conformsTo(booleanType)) {
            ErrorHandling.printError(ctx, "Not a valid conditional expression in a while statement");
            validation = false;
         }
         visit(ctx.trueSL);
         ctx.expr().eType=booleanType;
      }
      return validation;
   }


   @Override
   public Boolean visitIncrement(MainGramParser.IncrementContext ctx) {
      String var = ctx.ID().getText();
      Boolean validation = true;
      if (MainGramParser.symbolTable.containsKey(var)) {
         Symbol sb = MainGramParser.symbolTable.get(var);
         if (!sb.type().isNumeric()) {
            ErrorHandling.printError(ctx, "Cannot use operator \"" + ctx.incre.getText() + "\"for non numeric type");
            validation = false;
         }
         if (!sb.type().conformsTo(integerType)) {
            ErrorHandling.printError(ctx, "Cannot use operator \"" + ctx.incre.getText() + "\"for type real");
            validation = false;
         }
         if (!sb.valueDefined()) {
            ErrorHandling.printError(ctx, "Variable \"" + sb.name() + "\" was not initialized");
            validation = false;
         }
      } else {
         ErrorHandling.printError(ctx, "Variable \"" + var + "\" not defined");
         validation = false;
      }
      return validation;
   }

   @Override
   public Boolean visitTypeInt(MainGramParser.TypeIntContext ctx) {
      return true;
   }

   @Override
   public Boolean visitTypeReal(MainGramParser.TypeRealContext ctx) {
      return true;
   }

   @Override
   public Boolean visitTypeBool(MainGramParser.TypeBoolContext ctx) {
      return true;
   }

   @Override
   public Boolean visitTypeStr(MainGramParser.TypeStrContext ctx) {
      return true;
   }

   @Override
   public Boolean visitDimensionType(MainGramParser.DimensionTypeContext ctx) {
      String dimname = ctx.ID().getText();
      if (DimensionsParser.dimTable.containsKey(dimname)) {
         ctx.res = DimensionsParser.dimTable.get(dimname);
         return true;
      } else {
         ErrorHandling.printError(ctx, "Dimension \"" + dimname + "\" not found!");
         return false;
      }
   }

   @Override
   public Boolean visitStrExpr(MainGramParser.StrExprContext ctx) {
      ctx.eType=stringType;
      ctx.dim="noDim";
      ctx.uni="noUnit";
      return true;
   }

   @Override
   public Boolean visitAddSubExpr(MainGramParser.AddSubExprContext ctx) {
     boolean  validation=visit(ctx.e1) &&  visit(ctx.e2);
      boolean flag=false;
      if(validation){
         if(ctx.e1.eType.conformsTo(booleanType) && ctx.e2.eType.conformsTo(booleanType)){
            ErrorHandling.printError(ctx, "Cannot apply operator\\" + ctx.op.getText() + "\" to boolean operands");
            validation=false;
         }
         else{
            if(!ctx.e1.eType.conformsTo(stringType) && !ctx.e2.eType.conformsTo(stringType)){
               if(!ctx.e1.dim.equals(ctx.e2.dim)){
                  ErrorHandling.printError(ctx, "Cannot apply operator\"" + ctx.op.getText() + "\" to operands from diferent dimensions");
                  validation=false;
               } 
         // check unit of the context of the current expression
               else if(ctx.e1.uni.equals("noUnit") &&  ctx.e2.uni.equals("noUnit") ){
                  ctx.uni="noUnit";
               }
               else if((!ctx.e2.uni.equals("noUnit") &&  ctx.e1.uni.equals("noUnit")) ||( !ctx.e1.uni.equals("noUnit") &&  ctx.e2.uni.equals("noUnit"))){
                  ErrorHandling.printError(ctx, "Cannot apply operator\\" + ctx.op + "\" for a dimensional operand and a adimensional operand");
                  validation=false;
               }
               else if (!ctx.e1.uni.equals("noUnit") && !ctx.e2.uni.equals("noUnit")){
                  for (Dimension  d : DimensionsParser.dimTable.values()) {
                     if(!d.checkUnit(ctx.e1.uni) && !d.checkUnit(ctx.e2.uni)){
                         ctx.uni=d.getBaseUnit();
                         flag=true;
                     }
                 }
                  if(!flag){
                     ErrorHandling.printError(ctx, "Both operands must have units that were specified for this Dimension");
                     validation = false;
                  }
               }
            }
            else{
               ctx.uni="noUnit";
            }
            Type t = fecthType(ctx.e1.eType,ctx.e2.eType, ctx.op.getText());
            if ( t == null){
               ErrorHandling.printError(ctx, "Cannot apply operator\\" + ctx.op.getText() + "\" to non numeric operands");
            }
            else{
               ctx.eType=t;
               ctx.dim=ctx.e1.dim; //to perform add/sub operations they have to be of the same dimension and, with that, the dimension can be either the first or second operand' dimension
            }
         }
      }
      return validation;
   }

   @Override
   public Boolean visitEqualComparisonExpr(MainGramParser.EqualComparisonExprContext ctx) {
     boolean validation =  visit(ctx.e1) && visit(ctx.e2);
      if (validation) {
         if ((ctx.e1.eType.conformsTo(stringType) || ctx.e2.eType.conformsTo(stringType)) && !ctx.e1.eType.conformsTo(ctx.e2.eType)) {
            ErrorHandling.printError(ctx, "Cannot compare \"" + ctx.e1.eType + "\" with type "  + ctx.e2.eType);
            validation = false;
         } else if ((ctx.e1.eType.conformsTo(booleanType) || ctx.e2.eType.conformsTo(booleanType))
               && !ctx.e1.eType.conformsTo(ctx.e2.eType)) {
            ErrorHandling.printError(ctx, "Cannot compare \"" + ctx.e1.eType +  "\" with type " + ctx.e2.eType);
            validation = false;
         }
         else{
          
               if(!ctx.e1.eType.conformsTo(ctx.e2.eType) & !ctx.e2.eType.conformsTo(ctx.e1.eType)){
                  ErrorHandling.printError(ctx, "Cannot compare \"" + ctx.e1.eType +  "\" with type "  + ctx.e2.eType);
                  validation=false;
                              }
         }
      }
      ctx.eType = booleanType;
      ctx.uni = "noUnit";
      ctx.dim = "noDim";
      return validation;
   }

   @Override
   public Boolean visitAndOrExpr(MainGramParser.AndOrExprContext ctx){
      Boolean validation = visit(ctx.e1) && visit (ctx.e2);
      if(validation){
         if( !ctx.e1.eType.conformsTo(booleanType) || !ctx.e2.eType.conformsTo(booleanType)){
            ErrorHandling.printError(ctx, "Cannot use operator \"" + ctx.op.getText() + "\" with these operands!");
            validation=false;
         }
         ctx.eType=booleanType;
         ctx.dim="noDim";
         ctx.uni="noUnit";
      }
   
      return validation;
   }


   @Override
   public Boolean visitIntegerExpr(MainGramParser.IntegerExprContext ctx) {
      boolean  validation = true;
      ctx.eType = integerType;
      boolean flag= false;
      if (ctx.unit() != null) {
         validation =  visit(ctx.unit());
         if (validation) {
            String uni = ctx.unit().getText().replace("(", "").replace(")", "");
            for(Dimension dd : DimensionsParser.dimTable.values()){
               if(!dd.checkUnit(uni)){
                  ctx.uni=uni;
                  ctx.dim=dd.name();
                  flag=true;
                  validation=true;
               }
            }
            if(!flag){
               ErrorHandling.printError(ctx, "Unit not Found!");
               validation=false;
            }

         } else {
            ErrorHandling.printError(ctx, "Invalid Unit");
         }
      } else {
         ctx.dim = "noDim";
         ctx.uni = "noUnit";
      }

      return validation;
   }

   @Override
   public Boolean visitRealExpr(MainGramParser.RealExprContext ctx) {
      ctx.eType = realType;
      boolean flag=false;
      boolean validation=true;
      if (ctx.unit() != null) {
         validation =  visit(ctx.unit());

         if (validation) {
            ctx.uni = ctx.unit().getText().replace("(", "").replace(")", "");
            for(Dimension dd : DimensionsParser.dimTable.values()){
               if(!dd.checkUnit(ctx.uni)){
                  ctx.dim=dd.name();
                  flag=true;
                  validation=true;
               }
            }
            if(!flag){
               ErrorHandling.printError(ctx, "Unit not Found!");
               validation=false;
            }
         } else {
            ErrorHandling.printError(ctx, "Invalid Unit");
         }
      } else {
         ctx.dim = "noDim";
         ctx.uni = "noUnit";
      }

      return validation;
   }


   @Override
   public Boolean visitBooleanExpr(MainGramParser.BooleanExprContext ctx) {
      ctx.eType = booleanType;
      ctx.dim = "noDim";
      ctx.uni = "noUnit";
      return true;
   }

   @Override
   public Boolean visitInputExpr(MainGramParser.InputExprContext ctx) {
     isinput=true;
     boolean validation= visit(ctx.input().type());

      if(validation){
         ctx.eType=ctx.input().type().res;
         
      }
      return validation;
   }

   @Override
   public Boolean visitParenExpr(MainGramParser.ParenExprContext ctx) {
      boolean validation =  visit(ctx.expr());
      if (validation) {
         ctx.eType = ctx.expr().eType;
         ctx.dim = ctx.expr().dim;
         ctx.uni = ctx.expr().uni;
      }
      return validation;
   }

   @Override
   public Boolean visitGreatLowComparisonExpr(MainGramParser.GreatLowComparisonExprContext ctx) {
      Boolean validation =  visit(ctx.e1) &&  visit(ctx.e2);
      if (validation) {
         if (!ctx.e1.eType.isNumeric() || !ctx.e2.eType.isNumeric()) {
            ErrorHandling.printError(ctx, "Cannot Use operator \"" + ctx.op.getText() + "\" for Non Numeric Types of Expressions");
            validation = false;
         }
         if(!ctx.e1.uni.equals("noUnit")&& ctx.e2.uni.equals("noUnit") || ctx.e1.uni.equals("noUnit")&& !ctx.e2.uni.equals("noUnit")  ){
            ErrorHandling.printError(ctx,"Cannot compare an expression with no Dimension to a expression with Dimensions associated!");
            validation=false;
         }
         ctx.eType = booleanType;
         ctx.dim = "noDim";
         ctx.uni = "noUnit";
      }
      return validation;
   }

   @Override
   public Boolean visitNotExpr(MainGramParser.NotExprContext ctx) {
      boolean validation =  visit(ctx.expr());
      if (validation) {
         // check if type of the context of expr() is boolean
         if (ctx.expr().eType.conformsTo(booleanType)) {
            ctx.eType = booleanType;
            // boolean expressions dont have a dimension or unit associated
            ctx.dim = "noDim";
            ctx.uni = "noUnit";
         } else {
            ErrorHandling.printError(ctx, "Cannot use operator '!' for a non boolean expression");
         }
      }
      return validation;
   }

   @Override
   public Boolean visitSignExpr(MainGramParser.SignExprContext ctx) {
      Boolean validation =  visit(ctx.e);
      if (validation) {
         if (!ctx.e.eType.isNumeric()) {
            ErrorHandling.printError(ctx,
                  "Cannot Use operator\"" + ctx.sign + "\"for Non Numeric Types of Expressions");
            validation = false;
         }
         ctx.eType = ctx.e.eType;
         ctx.uni = ctx.e.uni;
         ctx.dim = ctx.e.dim;
      }
      return validation;
   }

   @Override
   public Boolean visitIncreExpr(MainGramParser.IncreExprContext ctx){
      Boolean validation = visit(ctx.increment());
      if(validation){
         
         ctx.eType=integerType;
         Symbol sb = MainGramParser.symbolTable.get(ctx.increment().ID().getText());
         ctx.dim=sb.dimensionName;
         ctx.uni=sb.unitName;
      }
      return validation;
   }
   @Override
   public Boolean visitMultDivExpr(MainGramParser.MultDivExprContext ctx) {
      Boolean  validation = visit (ctx.e1) &&  visit(ctx.e2);
      boolean flag=false;
      if(validation){
         if(!ctx.e1.eType.isNumeric() || !ctx.e2.eType.isNumeric()){
         ErrorHandling.printError(ctx, "Cannot apply operator \"" + ctx.op.getText() + "\" for non Numeric expressions!" );
         validation=false;
         }
         if(ctx.op.getText().equals("%")){
            if(!ctx.e1.dim.equals(ctx.e2.dim) & !ctx.e2.uni.equals("noUnit")){
               ErrorHandling.printError(ctx, "Cannot apply operator \"" + ctx.op.getText() + "\" for these operands" );
               validation=false;
               return validation;
            }
            else{
               Dimension d = DimensionsParser.dimTable.get(ctx.e1.dim);
               ctx.dim=ctx.e1.dim;
               if(d!=null) ctx.uni=d.getBaseUnit();
               else ctx.uni="noUnit";
               ctx.eType=fecthType(ctx.e1.eType,ctx.e2.eType, ctx.op.getText());
            }

         }
         else { 
            if (validation){
               if (ctx.e1.uni.equals("noUnit") && ctx.e2.uni.equals("noUnit")){
                  ctx.uni="noUnit";
                  ctx.dim="noDim";
               }
               else if(!ctx.e1.uni.equals("noUnit") && ctx.e2.uni.equals("noUnit")){
                  ctx.uni=ctx.e1.uni;
                  ctx.dim=ctx.e1.dim;
               }
               else if (ctx.e1.uni.equals("noUnit") && !ctx.e2.uni.equals("noUnit")){
                  ctx.uni=ctx.e2.uni;
                  ctx.dim=ctx.e2.dim;
               }
               else if(!ctx.e1.uni.equals("noUnit") && !ctx.e2.uni.equals("noUnit")){
                 
                  if(ctx.e1.dim.equals(ctx.e2.dim)){
                     for (Dimension  d : DimensionsParser.dimTable.values()) {
                        if(d.name().equals(ctx.e1.dim)){
                           ctx.dim=d.name();
                           ctx.uni=d.getBaseUnit();
                        }
                     }   
                  }
                  else ctx.uni=(ctx.e1.uni + ctx.op.getText() + ctx.e2.uni);
               }
               for (Dimension  d : DimensionsParser.dimTable.values()) {
                  if(!d.checkUnit(ctx.uni)){
                     ctx.dim=d.name();
                     flag=true;
                  }
               }
               if(!flag) ctx.dim="noDim";
               ctx.eType=fecthType(ctx.e1.eType,ctx.e2.eType, ctx.op.getText());
            }
         }
            
      } 
      return validation;
   }

   @Override
   public Boolean visitPowExpr(MainGramParser.PowExprContext ctx) {
      boolean  validation =  visit(ctx.e1) &&  visit(ctx.e2);

      if (validation) {
         if (!(ctx.e1.eType.isNumeric() || ctx.e2.eType.isNumeric())) {
            ErrorHandling.printError(ctx, "Cannot Use pow operation for Non Numeric Types of Expressions");
            validation = false;
         }
         ctx.eType = ctx.e1.eType;
         ctx.uni = ctx.e1.uni;
         ctx.dim = ctx.e1.dim;
      }

      return validation;
   }

   @Override
   public Boolean visitIdExpr(MainGramParser.IdExprContext ctx) {
      boolean validation = true;
      String id = ctx.ID().getText();
      if (MainGramParser.symbolTable.containsKey(id)) {
         Symbol sb = MainGramParser.symbolTable.get(id);
         if (sb.valueDefined()) {
            ctx.eType = sb.type();
            ctx.uni = sb.unitName;
            ctx.dim = sb.dimensionName;

         } else {
            ErrorHandling.printError(ctx, "Variable \"" + id + "\"  has no value associated");
            validation = false;
         }
      } else {
         ErrorHandling.printError(ctx, "Variable \"" + id + "\"  not found");
         validation = false;
      }

      return validation;
   }

   @Override
   public Boolean visitUnitCheck(MainGramParser.UnitCheckContext ctx) {
      return true;
   }
}
