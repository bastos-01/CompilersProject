// Generated from Dimensions.g4 by ANTLR 4.8

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link DimensionsParser}.
 */
public interface DimensionsListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link DimensionsParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProg(DimensionsParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Prog}
	 * labeled alternative in {@link DimensionsParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProg(DimensionsParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Stat}
	 * labeled alternative in {@link DimensionsParser#stats}.
	 * @param ctx the parse tree
	 */
	void enterStat(DimensionsParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Stat}
	 * labeled alternative in {@link DimensionsParser#stats}.
	 * @param ctx the parse tree
	 */
	void exitStat(DimensionsParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declar}
	 * labeled alternative in {@link DimensionsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclar(DimensionsParser.DeclarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declar}
	 * labeled alternative in {@link DimensionsParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclar(DimensionsParser.DeclarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code addUn}
	 * labeled alternative in {@link DimensionsParser#addunit}.
	 * @param ctx the parse tree
	 */
	void enterAddUn(DimensionsParser.AddUnContext ctx);
	/**
	 * Exit a parse tree produced by the {@code addUn}
	 * labeled alternative in {@link DimensionsParser#addunit}.
	 * @param ctx the parse tree
	 */
	void exitAddUn(DimensionsParser.AddUnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeNormal}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeNormal(DimensionsParser.TypeNormalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeNormal}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeNormal(DimensionsParser.TypeNormalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeVars}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeVars(DimensionsParser.TypeVarsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeVars}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeVars(DimensionsParser.TypeVarsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TypeConversions}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeConversions(DimensionsParser.TypeConversionsContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TypeConversions}
	 * labeled alternative in {@link DimensionsParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeConversions(DimensionsParser.TypeConversionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link DimensionsParser#conversion}.
	 * @param ctx the parse tree
	 */
	void enterConversion(DimensionsParser.ConversionContext ctx);
	/**
	 * Exit a parse tree produced by {@link DimensionsParser#conversion}.
	 * @param ctx the parse tree
	 */
	void exitConversion(DimensionsParser.ConversionContext ctx);
	/**
	 * Enter a parse tree produced by {@link DimensionsParser#polynomial}.
	 * @param ctx the parse tree
	 */
	void enterPolynomial(DimensionsParser.PolynomialContext ctx);
	/**
	 * Exit a parse tree produced by {@link DimensionsParser#polynomial}.
	 * @param ctx the parse tree
	 */
	void exitPolynomial(DimensionsParser.PolynomialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code realMonomial}
	 * labeled alternative in {@link DimensionsParser#monomial}.
	 * @param ctx the parse tree
	 */
	void enterRealMonomial(DimensionsParser.RealMonomialContext ctx);
	/**
	 * Exit a parse tree produced by the {@code realMonomial}
	 * labeled alternative in {@link DimensionsParser#monomial}.
	 * @param ctx the parse tree
	 */
	void exitRealMonomial(DimensionsParser.RealMonomialContext ctx);
	/**
	 * Enter a parse tree produced by the {@code const}
	 * labeled alternative in {@link DimensionsParser#monomial}.
	 * @param ctx the parse tree
	 */
	void enterConst(DimensionsParser.ConstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code const}
	 * labeled alternative in {@link DimensionsParser#monomial}.
	 * @param ctx the parse tree
	 */
	void exitConst(DimensionsParser.ConstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DTypeCheck}
	 * labeled alternative in {@link DimensionsParser#datatype}.
	 * @param ctx the parse tree
	 */
	void enterDTypeCheck(DimensionsParser.DTypeCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DTypeCheck}
	 * labeled alternative in {@link DimensionsParser#datatype}.
	 * @param ctx the parse tree
	 */
	void exitDTypeCheck(DimensionsParser.DTypeCheckContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unitCheck}
	 * labeled alternative in {@link DimensionsParser#unit}.
	 * @param ctx the parse tree
	 */
	void enterUnitCheck(DimensionsParser.UnitCheckContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unitCheck}
	 * labeled alternative in {@link DimensionsParser#unit}.
	 * @param ctx the parse tree
	 */
	void exitUnitCheck(DimensionsParser.UnitCheckContext ctx);
	/**
	 * Enter a parse tree produced by {@link DimensionsParser#number}.
	 * @param ctx the parse tree
	 */
	void enterNumber(DimensionsParser.NumberContext ctx);
	/**
	 * Exit a parse tree produced by {@link DimensionsParser#number}.
	 * @param ctx the parse tree
	 */
	void exitNumber(DimensionsParser.NumberContext ctx);
}