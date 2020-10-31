// Generated from Dimensions.g4 by ANTLR 4.8

import java.util.Map;
import java.util.HashMap;

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DimensionsParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, SIGN=11, REAL=12, INTEGER=13, ID=14, LETTER=15, COMMENT=16, MULTICOMMENT=17, 
		WS=18;
	public static final int
		RULE_program = 0, RULE_stats = 1, RULE_declaration = 2, RULE_addunit = 3, 
		RULE_type = 4, RULE_conversion = 5, RULE_polynomial = 6, RULE_monomial = 7, 
		RULE_datatype = 8, RULE_unit = 9, RULE_number = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "stats", "declaration", "addunit", "type", "conversion", "polynomial", 
			"monomial", "datatype", "unit", "number"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "';'", "'->'", "'-> addUnit'", "'*'", "'/'", "'='", "'real'", "'integer'", 
			"'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, "SIGN", 
			"REAL", "INTEGER", "ID", "LETTER", "COMMENT", "MULTICOMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Dimensions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }


	static protected Map <String,Dimension> dimTable = new HashMap<>();                                          // ( m, Length )

	public DimensionsParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgramContext extends ParserRuleContext {
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	 
		public ProgramContext() { }
		public void copyFrom(ProgramContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ProgContext extends ProgramContext {
		public TerminalNode EOF() { return getToken(DimensionsParser.EOF, 0); }
		public List<StatsContext> stats() {
			return getRuleContexts(StatsContext.class);
		}
		public StatsContext stats(int i) {
			return getRuleContext(StatsContext.class,i);
		}
		public ProgContext(ProgramContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			_localctx = new ProgContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==ID) {
				{
				{
				setState(22);
				stats();
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatsContext extends ParserRuleContext {
		public StatsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stats; }
	 
		public StatsContext() { }
		public void copyFrom(StatsContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class StatContext extends StatsContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AddunitContext addunit() {
			return getRuleContext(AddunitContext.class,0);
		}
		public StatContext(StatsContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatsContext stats() throws RecognitionException {
		StatsContext _localctx = new StatsContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_stats);
		try {
			_localctx = new StatContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(32);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(30);
				declaration();
				}
				break;
			case 2:
				{
				setState(31);
				addunit();
				}
				break;
			}
			setState(34);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
	 
		public DeclarationContext() { }
		public void copyFrom(DeclarationContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DeclarContext extends DeclarationContext {
		public TerminalNode ID() { return getToken(DimensionsParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public DeclarContext(DeclarationContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterDeclar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitDeclar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitDeclar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_declaration);
		try {
			_localctx = new DeclarContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(ID);
			setState(37);
			match(T__1);
			setState(38);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AddunitContext extends ParserRuleContext {
		public AddunitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addunit; }
	 
		public AddunitContext() { }
		public void copyFrom(AddunitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddUnContext extends AddunitContext {
		public TerminalNode ID() { return getToken(DimensionsParser.ID, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public AddUnContext(AddunitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterAddUn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitAddUn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitAddUn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AddunitContext addunit() throws RecognitionException {
		AddunitContext _localctx = new AddunitContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_addunit);
		try {
			_localctx = new AddUnContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(40);
			match(ID);
			setState(41);
			match(T__2);
			setState(42);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	 
		public TypeContext() { }
		public void copyFrom(TypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TypeConversionsContext extends TypeContext {
		public ConversionContext conversion() {
			return getRuleContext(ConversionContext.class,0);
		}
		public TypeConversionsContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterTypeConversions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitTypeConversions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitTypeConversions(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeNormalContext extends TypeContext {
		public DatatypeContext datatype() {
			return getRuleContext(DatatypeContext.class,0);
		}
		public UnitContext unit() {
			return getRuleContext(UnitContext.class,0);
		}
		public TypeNormalContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterTypeNormal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitTypeNormal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitTypeNormal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TypeVarsContext extends TypeContext {
		public Token op;
		public List<TerminalNode> ID() { return getTokens(DimensionsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DimensionsParser.ID, i);
		}
		public TypeVarsContext(TypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterTypeVars(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitTypeVars(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitTypeVars(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_type);
		int _la;
		try {
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				_localctx = new TypeNormalContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				datatype();
				setState(45);
				unit();
				}
				break;
			case 2:
				_localctx = new TypeVarsContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(47);
				match(ID);
				setState(48);
				((TypeVarsContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
					((TypeVarsContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(49);
				match(ID);
				}
				break;
			case 3:
				_localctx = new TypeConversionsContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(50);
				conversion();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConversionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(DimensionsParser.ID, 0); }
		public PolynomialContext polynomial() {
			return getRuleContext(PolynomialContext.class,0);
		}
		public ConversionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conversion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterConversion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitConversion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitConversion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConversionContext conversion() throws RecognitionException {
		ConversionContext _localctx = new ConversionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_conversion);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(53);
			match(ID);
			setState(54);
			match(T__5);
			setState(55);
			polynomial();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PolynomialContext extends ParserRuleContext {
		public Token sg;
		public List<MonomialContext> monomial() {
			return getRuleContexts(MonomialContext.class);
		}
		public MonomialContext monomial(int i) {
			return getRuleContext(MonomialContext.class,i);
		}
		public List<TerminalNode> SIGN() { return getTokens(DimensionsParser.SIGN); }
		public TerminalNode SIGN(int i) {
			return getToken(DimensionsParser.SIGN, i);
		}
		public PolynomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_polynomial; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterPolynomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitPolynomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitPolynomial(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PolynomialContext polynomial() throws RecognitionException {
		PolynomialContext _localctx = new PolynomialContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_polynomial);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(58);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SIGN) {
				{
				setState(57);
				((PolynomialContext)_localctx).sg = match(SIGN);
				}
			}

			setState(60);
			monomial();
			}
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==SIGN) {
				{
				{
				setState(62);
				match(SIGN);
				setState(63);
				monomial();
				}
				}
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class MonomialContext extends ParserRuleContext {
		public MonomialContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_monomial; }
	 
		public MonomialContext() { }
		public void copyFrom(MonomialContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RealMonomialContext extends MonomialContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public TerminalNode ID() { return getToken(DimensionsParser.ID, 0); }
		public RealMonomialContext(MonomialContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterRealMonomial(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitRealMonomial(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitRealMonomial(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ConstContext extends MonomialContext {
		public NumberContext number() {
			return getRuleContext(NumberContext.class,0);
		}
		public ConstContext(MonomialContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterConst(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitConst(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitConst(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MonomialContext monomial() throws RecognitionException {
		MonomialContext _localctx = new MonomialContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_monomial);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				_localctx = new RealMonomialContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(69);
				number();
				setState(70);
				match(T__3);
				setState(71);
				match(ID);
				}
				break;
			case 2:
				_localctx = new ConstContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(73);
				number();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DatatypeContext extends ParserRuleContext {
		public DatatypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_datatype; }
	 
		public DatatypeContext() { }
		public void copyFrom(DatatypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DTypeCheckContext extends DatatypeContext {
		public Token dt;
		public DTypeCheckContext(DatatypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterDTypeCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitDTypeCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitDTypeCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DatatypeContext datatype() throws RecognitionException {
		DatatypeContext _localctx = new DatatypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_datatype);
		int _la;
		try {
			_localctx = new DTypeCheckContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			((DTypeCheckContext)_localctx).dt = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==T__6 || _la==T__7) ) {
				((DTypeCheckContext)_localctx).dt = (Token)_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnitContext extends ParserRuleContext {
		public UnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unit; }
	 
		public UnitContext() { }
		public void copyFrom(UnitContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UnitCheckContext extends UnitContext {
		public Token op;
		public List<TerminalNode> ID() { return getTokens(DimensionsParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(DimensionsParser.ID, i);
		}
		public UnitCheckContext(UnitContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterUnitCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitUnitCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitUnitCheck(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnitContext unit() throws RecognitionException {
		UnitContext _localctx = new UnitContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_unit);
		int _la;
		try {
			_localctx = new UnitCheckContext(_localctx);
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__8);
			setState(79);
			match(ID);
			setState(84);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__3 || _la==T__4) {
				{
				{
				setState(80);
				((UnitCheckContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__3 || _la==T__4) ) {
					((UnitCheckContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(81);
				match(ID);
				}
				}
				setState(86);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(87);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NumberContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(DimensionsParser.INTEGER, 0); }
		public TerminalNode REAL() { return getToken(DimensionsParser.REAL, 0); }
		public NumberContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_number; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).enterNumber(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof DimensionsListener ) ((DimensionsListener)listener).exitNumber(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof DimensionsVisitor ) return ((DimensionsVisitor<? extends T>)visitor).visitNumber(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NumberContext number() throws RecognitionException {
		NumberContext _localctx = new NumberContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_number);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89);
			_la = _input.LA(1);
			if ( !(_la==REAL || _la==INTEGER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24^\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\3\3\3\3\5\3#\n\3\3\3\3"+
		"\3\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\66"+
		"\n\6\3\7\3\7\3\7\3\7\3\b\5\b=\n\b\3\b\3\b\3\b\3\b\7\bC\n\b\f\b\16\bF\13"+
		"\b\3\t\3\t\3\t\3\t\3\t\5\tM\n\t\3\n\3\n\3\13\3\13\3\13\3\13\7\13U\n\13"+
		"\f\13\16\13X\13\13\3\13\3\13\3\f\3\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24"+
		"\26\2\5\3\2\6\7\3\2\t\n\3\2\16\17\2Z\2\33\3\2\2\2\4\"\3\2\2\2\6&\3\2\2"+
		"\2\b*\3\2\2\2\n\65\3\2\2\2\f\67\3\2\2\2\16<\3\2\2\2\20L\3\2\2\2\22N\3"+
		"\2\2\2\24P\3\2\2\2\26[\3\2\2\2\30\32\5\4\3\2\31\30\3\2\2\2\32\35\3\2\2"+
		"\2\33\31\3\2\2\2\33\34\3\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\37\7\2\2"+
		"\3\37\3\3\2\2\2 #\5\6\4\2!#\5\b\5\2\" \3\2\2\2\"!\3\2\2\2#$\3\2\2\2$%"+
		"\7\3\2\2%\5\3\2\2\2&\'\7\20\2\2\'(\7\4\2\2()\5\n\6\2)\7\3\2\2\2*+\7\20"+
		"\2\2+,\7\5\2\2,-\5\n\6\2-\t\3\2\2\2./\5\22\n\2/\60\5\24\13\2\60\66\3\2"+
		"\2\2\61\62\7\20\2\2\62\63\t\2\2\2\63\66\7\20\2\2\64\66\5\f\7\2\65.\3\2"+
		"\2\2\65\61\3\2\2\2\65\64\3\2\2\2\66\13\3\2\2\2\678\7\20\2\289\7\b\2\2"+
		"9:\5\16\b\2:\r\3\2\2\2;=\7\r\2\2<;\3\2\2\2<=\3\2\2\2=>\3\2\2\2>?\5\20"+
		"\t\2?D\3\2\2\2@A\7\r\2\2AC\5\20\t\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE\3"+
		"\2\2\2E\17\3\2\2\2FD\3\2\2\2GH\5\26\f\2HI\7\6\2\2IJ\7\20\2\2JM\3\2\2\2"+
		"KM\5\26\f\2LG\3\2\2\2LK\3\2\2\2M\21\3\2\2\2NO\t\3\2\2O\23\3\2\2\2PQ\7"+
		"\13\2\2QV\7\20\2\2RS\t\2\2\2SU\7\20\2\2TR\3\2\2\2UX\3\2\2\2VT\3\2\2\2"+
		"VW\3\2\2\2WY\3\2\2\2XV\3\2\2\2YZ\7\f\2\2Z\25\3\2\2\2[\\\t\4\2\2\\\27\3"+
		"\2\2\2\t\33\"\65<DLV";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}