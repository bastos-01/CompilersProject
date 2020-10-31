// Generated from MainGram.g4 by ANTLR 4.8

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MainGramParser}.
 */
public interface MainGramListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MainGramParser#main}.
	 * @param ctx the parse tree
	 */
	void enterMain(MainGramParser.MainContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#main}.
	 * @param ctx the parse tree
	 */
	void exitMain(MainGramParser.MainContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#statList}.
	 * @param ctx the parse tree
	 */
	void enterStatList(MainGramParser.StatListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#statList}.
	 * @param ctx the parse tree
	 */
	void exitStatList(MainGramParser.StatListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(MainGramParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(MainGramParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(MainGramParser.PrintContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(MainGramParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by the {@code importDimensionFile}
	 * labeled alternative in {@link MainGramParser#importDims}.
	 * @param ctx the parse tree
	 */
	void enterImportDimensionFile(MainGramParser.ImportDimensionFileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code importDimensionFile}
	 * labeled alternative in {@link MainGramParser#importDims}.
	 * @param ctx the parse tree
	 */
	void exitImportDimensionFile(MainGramParser.ImportDimensionFileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(MainGramParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(MainGramParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code decAssign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterDecAssign(MainGramParser.DecAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code decAssign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitDecAssign(MainGramParser.DecAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssign(MainGramParser.AssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssign(MainGramParser.AssignContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#idList}.
	 * @param ctx the parse tree
	 */
	void enterIdList(MainGramParser.IdListContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#idList}.
	 * @param ctx the parse tree
	 */
	void exitIdList(MainGramParser.IdListContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#conditionalstat}.
	 * @param ctx the parse tree
	 */
	void enterConditionalstat(MainGramParser.ConditionalstatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#conditionalstat}.
	 * @param ctx the parse tree
	 */
	void exitConditionalstat(MainGramParser.ConditionalstatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#conditional}.
	 * @param ctx the parse tree
	 */
	void enterConditional(MainGramParser.ConditionalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#conditional}.
	 * @param ctx the parse tree
	 */
	void exitConditional(MainGramParser.ConditionalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#elseif}.
	 * @param ctx the parse tree
	 */
	void enterElseif(MainGramParser.ElseifContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#elseif}.
	 * @param ctx the parse tree
	 */
	void exitElseif(MainGramParser.ElseifContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forCond}
	 * labeled alternative in {@link MainGramParser#forloop}.
	 * @param ctx the parse tree
	 */
	void enterForCond(MainGramParser.ForCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forCond}
	 * labeled alternative in {@link MainGramParser#forloop}.
	 * @param ctx the parse tree
	 */
	void exitForCond(MainGramParser.ForCondContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileCond}
	 * labeled alternative in {@link MainGramParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void enterWhileCond(MainGramParser.WhileCondContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileCond}
	 * labeled alternative in {@link MainGramParser#whileloop}.
	 * @param ctx the parse tree
	 */
	void exitWhileCond(MainGramParser.WhileCondContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#input}.
	 * @param ctx the parse tree
	 */
	void enterInput(MainGramParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#input}.
	 * @param ctx the parse tree
	 */
	void exitInput(MainGramParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by {@link MainGramParser#increment}.
	 * @param ctx the parse tree
	 */
	void enterIncrement(MainGramParser.IncrementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MainGramParser#increment}.
	 * @param ctx the parse tree
	 */
	void exitIncrement(MainGramParser.IncrementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(MainGramParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(MainGramParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeReal(MainGramParser.TypeRealContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeReal(MainGramParser.TypeRealContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(MainGramParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(MainGramParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeStr}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeStr(MainGramParser.TypeStrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeStr}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeStr(MainGramParser.TypeStrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DimensionType}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void enterDimensionType(MainGramParser.DimensionTypeContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DimensionType}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 */
	void exitDimensionType(MainGramParser.DimensionTypeContext ctx);
	/**
	 * Enter a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterStrExpr(MainGramParser.StrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitStrExpr(MainGramParser.StrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSubExpr(MainGramParser.AddSubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSubExpr(MainGramParser.AddSubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterEqualComparisonExpr(MainGramParser.EqualComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitEqualComparisonExpr(MainGramParser.EqualComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIntegerExpr(MainGramParser.IntegerExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIntegerExpr(MainGramParser.IntegerExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterRealExpr(MainGramParser.RealExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitRealExpr(MainGramParser.RealExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBooleanExpr(MainGramParser.BooleanExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBooleanExpr(MainGramParser.BooleanExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInputExpr(MainGramParser.InputExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInputExpr(MainGramParser.InputExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParenExpr(MainGramParser.ParenExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParenExpr(MainGramParser.ParenExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greatLowComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGreatLowComparisonExpr(MainGramParser.GreatLowComparisonExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greatLowComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGreatLowComparisonExpr(MainGramParser.GreatLowComparisonExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code increExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIncreExpr(MainGramParser.IncreExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code increExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIncreExpr(MainGramParser.IncreExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNotExpr(MainGramParser.NotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNotExpr(MainGramParser.NotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSignExpr(MainGramParser.SignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSignExpr(MainGramParser.SignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMultDivExpr(MainGramParser.MultDivExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMultDivExpr(MainGramParser.MultDivExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAndOrExpr(MainGramParser.AndOrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAndOrExpr(MainGramParser.AndOrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPowExpr(MainGramParser.PowExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPowExpr(MainGramParser.PowExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MainGramParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MainGramParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitCheck}
	 * labeled alternative in {@link MainGramParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitCheck(MainGramParser.UnitCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitCheck}
	 * labeled alternative in {@link MainGramParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitCheck(MainGramParser.UnitCheckContext ctx);
	/**
	 * Enter a parse tree produced by the {@code dimInfo}
	 * labeled alternative in {@link MainGramParser#dimensioninfo}.
	 * @param ctx the parse tree
	 */
	void enterDimInfo(MainGramParser.DimInfoContext ctx);
	/**
	 * Exit a parse tree produced by the {@code dimInfo}
	 * labeled alternative in {@link MainGramParser#dimensioninfo}.
	 * @param ctx the parse tree
	 */
	void exitDimInfo(MainGramParser.DimInfoContext ctx);
}