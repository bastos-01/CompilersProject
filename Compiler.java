import java.io.File;
import java.util.Iterator;


import org.antlr.v4.runtime.tree.TerminalNode;
import org.antlr.v4.runtime.ParserRuleContext;

import org.stringtemplate.v4.*;



public class Compiler extends MainGramBaseVisitor<ST> {
   protected int varCount = 0;
   protected String target = "java"; // default
   protected STGroup stg = null;

   private String newVar(){
      varCount+=1;
      return "v"+varCount;
   }
   @Override public ST visitMain(MainGramParser.MainContext ctx) {
      assert validTarget(target);

      stg = new STGroupFile(target+".stg");
      ST res = stg.getInstanceOf("module");
      res.add("stat", visit(ctx.statList()));
      return res;
   }

   @Override public ST visitStatList(MainGramParser.StatListContext ctx) {
      ST res = stg.getInstanceOf("stats");
      for(MainGramParser.StatContext sc: ctx.stat()){
         res.add("stat", visit(sc));}
      return res;   
   }


   @Override public ST visitPrint(MainGramParser.PrintContext ctx) {
      ST res = stg.getInstanceOf("print");
      res.add("stat", visit(ctx.expr()));
      res.add("expr",ctx.expr().varName);
      return res;
   }

   @Override public ST visitDeclaration(MainGramParser.DeclarationContext ctx) {
     ST res =stg.getInstanceOf("stats");
      for(TerminalNode t: ctx.idList().ID())
      {
         String id = t.getText();
         Symbol s = MainGramParser.symbolTable.get(id);
         s.setVarName(newVar());
         ST decl = stg.getInstanceOf("decl");
         decl.add("type", s.type().getPrimType());
         decl.add("var",s.varName());
         res.add("stat",decl.render());
     }
     return res;
   }

   @Override public ST visitDecAssign(MainGramParser.DecAssignContext ctx) {
      ST res =stg.getInstanceOf("stats");
      for(TerminalNode t: ctx.declaration().idList().ID())
      {
         String id = t.getText();
         Symbol s = MainGramParser.symbolTable.get(id);
         s.setVarName(newVar());
         ST dec = stg.getInstanceOf("decl");
         dec.add("type", s.type().getPrimType());
         dec.add("var",s.varName());
         dec.add("stat", visit(ctx.expr()).render());
         dec.add("value",ctx.expr().varName);
         res.add("stat",dec.render());
      }
      return res;
   }

   @Override public ST visitAssign(MainGramParser.AssignContext ctx) {
      ST res = stg.getInstanceOf("assign");
      String id = ctx.ID().getText();
      Symbol s = MainGramParser.symbolTable.get(id);
      res.add("stat", visit(ctx.expr()).render());
      res.add("var", s.varName());
      res.add("value", ctx.expr().varName);

      return res;
   }


   @Override public ST visitConditional(MainGramParser.ConditionalContext ctx) {
      ST res = stg.getInstanceOf("conditional");
      res.add("stat",visit(ctx.expr()).render());
      res.add("expr",ctx.expr().varName);
      res.add("true_stat",visit(ctx.trueSL).render());
      if(ctx.falseSL != null){
         //checking if its and else if , or just an else, in case of else if , it is generated another if else block inside the if block
         if(ctx.falseSL.conditional() != null)  
         res.add("false_stat", visit(ctx.falseSL).render());
         else 
         res.add("false_stat",visit(ctx.falseSL.statList()).render());
      }
      return res;
   }

   @Override public ST visitForCond(MainGramParser.ForCondContext ctx) {
      ST res = stg.getInstanceOf("conditionloop");
      String a = "";
      res.add("statfor",a=visit(ctx.assignment()).render());
      String inc = a.split("\n")[a.split("\n").length - 1].split(" ")[1].replace(";","");
      res.add("statbefore",visit(ctx.expr(0)).render());
      res.add("var",ctx.expr(0).varName);
      res.add("statafter",visit(ctx.trueSL).render());
      res.add("statafter", visit(ctx.expr(1)).render());
      ST assg = stg.getInstanceOf("assign");
      assg.add("var",inc);
      assg.add("value",ctx.expr(1).varName);
      res.add("statafter",assg.render());
      return res;
   }

   @Override public ST visitWhileCond(MainGramParser.WhileCondContext ctx) {
      ST res = stg.getInstanceOf("conditionloop");
      res.add("statbefore",visit(ctx.expr()).render());
      res.add("var",ctx.expr().varName);
      res.add("statafter",visit(ctx.trueSL).render());
      return res; 
   }


   @Override public ST visitIncrement(MainGramParser.IncrementContext ctx) {
      ST res = stg.getInstanceOf("inc");
      String id = ctx.ID().getText();
      res.add("var",MainGramParser.symbolTable.get(id).varName());
      res.add("op",ctx.incre.getText());
      return res;
   }

   @Override public ST visitStrExpr(MainGramParser.StrExprContext ctx) {
      ST res = stg.getInstanceOf("decl");
      ctx.varName = newVar();
      res.add("type", "string");
      res.add("var", ctx.varName);
      res.add("value", ctx.STRING().getText());
      return res;
   }

   @Override public ST visitAddSubExpr(MainGramParser.AddSubExprContext ctx) {
      ctx.varName = newVar();
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.eType.getPrimType(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);  
    }

   @Override public ST visitEqualComparisonExpr(MainGramParser.EqualComparisonExprContext ctx) {
    ctx.varName = newVar();
    ST res = stg.getInstanceOf("stats");
    res.add("stat",visit(ctx.e1));
    res.add("stat",visit(ctx.e2));
    if (ctx.e1.eType.getPrimType().equals("string") && ctx.e2.eType.getPrimType().equals("string")){
       if(ctx.op.equals("==")){
       ST eq = equalExpression(ctx, "equalExpression", ctx.eType.getPrimType(), ctx.varName, ctx.e1.varName, ctx.e2.varName);
       res.add("stat",eq.render());
       return res;

      }
      else {
       ST eq = equalExpression(ctx, "notEqualExpression", ctx.eType.getPrimType(), ctx.varName, ctx.e1.varName, ctx.e2.varName);
       res.add("stat",eq.render());
       return res;
      }
    }
    else
   return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.eType.name(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);
   
   }


   
   @Override public ST  visitAndOrExpr(MainGramParser.AndOrExprContext ctx){
      ctx.varName = newVar();
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.eType.name(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);
   }
   @Override public ST visitIntegerExpr(MainGramParser.IntegerExprContext ctx) {
      ST res = stg.getInstanceOf("decl");
      ctx.varName = newVar();
      res.add("type", "integer");
      res.add("var", ctx.varName);
      int val = Integer.parseInt(ctx.INTEGER().getText());
      if (ctx.unit()!=null){
         String unit = ctx.unit().getText().replace("(","").replace(")","");
         for (Dimension d :DimensionsParser.dimTable.values()){
            if (!d.checkUnit(unit)){
             double val2 =d.calcConversion(unit,val);
              val=(int)val2;
            }
         }
      }
      res.add("value", val );
      return res;
   }

   @Override public ST visitRealExpr(MainGramParser.RealExprContext ctx) {
      ST res = stg.getInstanceOf("decl");
      ctx.varName = newVar();
      res.add("type", "real");
      res.add("var", ctx.varName);
      double temp = Double.parseDouble(ctx.REAL().getText());
      if (ctx.unit()!=null){
         String unit = ctx.unit().getText().replace("(","").replace(")","");
         for (Dimension d : DimensionsParser.dimTable.values()){
            if (!d.checkUnit(unit)){
              
              temp=d.calcConversion(unit,temp);
            }
         }
      }
      double val = temp;
      res.add("value", val );
      return res;
   }

   @Override public ST visitBooleanExpr(MainGramParser.BooleanExprContext ctx) {
      ST res = stg.getInstanceOf("decl");
      ctx.varName = newVar();
      res.add("type", "boolean");
      res.add("var", ctx.varName);
      res.add("value", ctx.BOOLEAN().getText());
      return res;
   }

   @Override public ST visitInputExpr(MainGramParser.InputExprContext ctx) {
      ST res = stg.getInstanceOf("input");
      ctx.varName=newVar();
      visit(ctx.input().type());
      res.add("type",ctx.input().type().res.getPrimType());
      res.add("var",ctx.varName);
      res.add("prompt",ctx.input().STRING().getText());
      return res;
      }

   @Override
      public ST visitIncreExpr(MainGramParser.IncreExprContext ctx){   
      ST res = stg.getInstanceOf("inc");
      String id = ctx.increment().ID().getText();
      ctx.varName=MainGramParser.symbolTable.get(id).varName();
      res.add("var",ctx.varName);
      res.add("op",ctx.increment().incre.getText());
      return res;
      }  
   @Override public ST visitParenExpr(MainGramParser.ParenExprContext ctx) {
      ST result = visit(ctx.expr());

      ctx.varName=ctx.expr().varName;
      return result;
   }

   @Override public ST visitGreatLowComparisonExpr(MainGramParser.GreatLowComparisonExprContext ctx) {
      ctx.varName = newVar();
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.eType.name(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);
   }



   @Override public ST visitNotExpr(MainGramParser.NotExprContext ctx) {
      ST res = stg.getInstanceOf("negationExpression");
      ctx.varName = newVar();
      res.add("stat",visit(ctx.e).render());
      res.add("type", ctx.eType.getPrimType());
      res.add("var", ctx.varName);
      res.add("op","!");
      res.add("e",ctx.expr().varName);
      return res;
   }

   @Override public ST visitSignExpr(MainGramParser.SignExprContext ctx) {
      ST res = stg.getInstanceOf("stats");
      res.add("stat",visit(ctx.e).render());

      ST bn = stg.getInstanceOf("binaryOperator");
      ctx.varName = newVar();
      bn.add("type", ctx.eType.getPrimType());
      bn.add("var", ctx.varName);
      bn.add("e1", ctx.expr().varName);
      bn.add("op", ctx.sign.getText());
      res.add("stat",bn.render());
      return res;
   }

   @Override public ST visitMultDivExpr(MainGramParser.MultDivExprContext ctx) {
      ctx.varName = newVar();
      return binaryExpression(ctx, visit(ctx.e1).render(), visit(ctx.e2).render(), ctx.eType.getPrimType(), ctx.varName, ctx.e1.varName, ctx.op.getText(), ctx.e2.varName);  
   }

   @Override public ST visitPowExpr(MainGramParser.PowExprContext ctx) {
      ST res = stg.getInstanceOf("powerExpression");
      ctx.varName = newVar();
      res.add("type", ctx.eType.getPrimType());
      res.add("var", ctx.varName);
      res.add("stat", visit(ctx.e1).render());
      res.add("stat", visit(ctx.e2).render());
      res.add("e1", ctx.e1.varName);
      res.add("e2", ctx.e2.varName);
      return res;
   }

   @Override public ST visitIdExpr(MainGramParser.IdExprContext ctx) {
      ST res = stg.getInstanceOf("decl");
      String id = ctx.ID().getText();
      ctx.varName = newVar();
      res.add("type",ctx.eType.getPrimType());
      res.add("var",ctx.varName);
      res.add("value",MainGramParser.symbolTable.get(id).varName());
      return res;
   }

   @Override 
   public ST visitDimInfo(MainGramParser.DimInfoContext ctx){
      ST res = stg.getInstanceOf("print");
      res.add("stat",visit(ctx.expr()));
      String info="";
      if(ctx.expr().dim.equals("noDim"))
      info = "The variable has no Dimension or Unit"; 
      else
      info = "The variable  has Dimension "  + ctx.expr().dim +  " and the Base Unit "  + ctx.expr().uni  ; 
      res.add("expr","\"" + info + "\"");
      return res;
   }


   protected ST binaryExpression(ParserRuleContext ctx, String e1Stats, String e2Stats, String type, String var, String e1Var, String op, String e2Var) {
      ST res = stg.getInstanceOf("binaryExpression");
      res.add("stat", e1Stats);
      res.add("stat", e2Stats);
      res.add("type", type);
      res.add("var", var);
      res.add("e1", e1Var);
      res.add("op", op);
      res.add("e2", e2Var);
      return res;
   }


   protected ST equalExpression(ParserRuleContext ctx,String instance,String type, String var, String e1Var,String e2Var) {
      ST res = stg.getInstanceOf(instance);
      res.add("type", type);
      res.add("var", var);
      res.add("e1", e1Var);
      res.add("e2", e2Var);
      return res;
   }
   public boolean validTarget(String target) {
      File f = new File(target+".stg");

      return (f.exists() && f.isFile() && f.canRead());
   }

   public void setTarget(String target) {
      assert validTarget(target);

      this.target = target;
   }
}
