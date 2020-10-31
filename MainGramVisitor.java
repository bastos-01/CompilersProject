// Generated from MainGram.g4 by ANTLR 4.8

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MainGramParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MainGramVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MainGramParser#main}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMain(MainGramParser.MainContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#statList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatList(MainGramParser.StatListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(MainGramParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(MainGramParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code importDimensionFile}
	 * labeled alternative in {@link MainGramParser#importDims}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportDimensionFile(MainGramParser.ImportDimensionFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(MainGramParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decAssign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecAssign(MainGramParser.DecAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assign}
	 * labeled alternative in {@link MainGramParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(MainGramParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#idList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdList(MainGramParser.IdListContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#conditionalstat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditionalstat(MainGramParser.ConditionalstatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#conditional}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConditional(MainGramParser.ConditionalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#elseif}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElseif(MainGramParser.ElseifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code forCond}
	 * labeled alternative in {@link MainGramParser#forloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForCond(MainGramParser.ForCondContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileCond}
	 * labeled alternative in {@link MainGramParser#whileloop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileCond(MainGramParser.WhileCondContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#input}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(MainGramParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by {@link MainGramParser#increment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncrement(MainGramParser.IncrementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(MainGramParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeReal}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeReal(MainGramParser.TypeRealContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(MainGramParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeStr}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeStr(MainGramParser.TypeStrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DimensionType}
	 * labeled alternative in {@link MainGramParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimensionType(MainGramParser.DimensionTypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code strExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStrExpr(MainGramParser.StrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code addSubExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSubExpr(MainGramParser.AddSubExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equalComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualComparisonExpr(MainGramParser.EqualComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code integerExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntegerExpr(MainGramParser.IntegerExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code realExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRealExpr(MainGramParser.RealExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code booleanExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExpr(MainGramParser.BooleanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code inputExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInputExpr(MainGramParser.InputExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parenExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenExpr(MainGramParser.ParenExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code greatLowComparisonExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreatLowComparisonExpr(MainGramParser.GreatLowComparisonExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code increExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncreExpr(MainGramParser.IncreExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotExpr(MainGramParser.NotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code signExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSignExpr(MainGramParser.SignExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code multDivExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultDivExpr(MainGramParser.MultDivExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andOrExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndOrExpr(MainGramParser.AndOrExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code powExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPowExpr(MainGramParser.PowExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MainGramParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdExpr(MainGramParser.IdExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code unitCheck}
	 * labeled alternative in {@link MainGramParser#unit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnitCheck(MainGramParser.UnitCheckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dimInfo}
	 * labeled alternative in {@link MainGramParser#dimensioninfo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDimInfo(MainGramParser.DimInfoContext ctx);
}