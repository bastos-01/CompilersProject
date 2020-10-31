// Generated from Dimensions.g4 by ANTLR 4.8
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class DimensionsLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.8", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, SIGN=11, REAL=12, INTEGER=13, ID=14, LETTER=15, COMMENT=16, MULTICOMMENT=17, 
		WS=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "SIGN", "REAL", "INTEGER", "ID", "LETTER", "COMMENT", "MULTICOMMENT", 
			"WS"
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


	public DimensionsLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Dimensions.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24\u008a\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\6\rR\n\r\r\r\16\rS\3\r"+
		"\3\r\7\rX\n\r\f\r\16\r[\13\r\3\16\6\16^\n\16\r\16\16\16_\3\17\3\17\3\17"+
		"\7\17e\n\17\f\17\16\17h\13\17\3\20\3\20\3\21\3\21\3\21\3\21\7\21p\n\21"+
		"\f\21\16\21s\13\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\7\22}\n\22"+
		"\f\22\16\22\u0080\13\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\4"+
		"q~\2\24\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17"+
		"\35\20\37\21!\22#\23%\24\3\2\6\4\2--//\3\2\62;\4\2C\\c|\5\2\13\f\17\17"+
		"\"\"\2\u0090\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5)\3\2\2\2\7,\3\2\2\2\t\67\3\2"+
		"\2\2\139\3\2\2\2\r;\3\2\2\2\17=\3\2\2\2\21B\3\2\2\2\23J\3\2\2\2\25L\3"+
		"\2\2\2\27N\3\2\2\2\31Q\3\2\2\2\33]\3\2\2\2\35a\3\2\2\2\37i\3\2\2\2!k\3"+
		"\2\2\2#x\3\2\2\2%\u0086\3\2\2\2\'(\7=\2\2(\4\3\2\2\2)*\7/\2\2*+\7@\2\2"+
		"+\6\3\2\2\2,-\7/\2\2-.\7@\2\2./\7\"\2\2/\60\7c\2\2\60\61\7f\2\2\61\62"+
		"\7f\2\2\62\63\7W\2\2\63\64\7p\2\2\64\65\7k\2\2\65\66\7v\2\2\66\b\3\2\2"+
		"\2\678\7,\2\28\n\3\2\2\29:\7\61\2\2:\f\3\2\2\2;<\7?\2\2<\16\3\2\2\2=>"+
		"\7t\2\2>?\7g\2\2?@\7c\2\2@A\7n\2\2A\20\3\2\2\2BC\7k\2\2CD\7p\2\2DE\7v"+
		"\2\2EF\7g\2\2FG\7i\2\2GH\7g\2\2HI\7t\2\2I\22\3\2\2\2JK\7*\2\2K\24\3\2"+
		"\2\2LM\7+\2\2M\26\3\2\2\2NO\t\2\2\2O\30\3\2\2\2PR\t\3\2\2QP\3\2\2\2RS"+
		"\3\2\2\2SQ\3\2\2\2ST\3\2\2\2TU\3\2\2\2UY\7\60\2\2VX\t\3\2\2WV\3\2\2\2"+
		"X[\3\2\2\2YW\3\2\2\2YZ\3\2\2\2Z\32\3\2\2\2[Y\3\2\2\2\\^\t\3\2\2]\\\3\2"+
		"\2\2^_\3\2\2\2_]\3\2\2\2_`\3\2\2\2`\34\3\2\2\2af\5\37\20\2be\5\37\20\2"+
		"ce\5\33\16\2db\3\2\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2g\36\3\2"+
		"\2\2hf\3\2\2\2ij\t\4\2\2j \3\2\2\2kl\7\61\2\2lm\7\61\2\2mq\3\2\2\2np\13"+
		"\2\2\2on\3\2\2\2ps\3\2\2\2qr\3\2\2\2qo\3\2\2\2rt\3\2\2\2sq\3\2\2\2tu\7"+
		"\f\2\2uv\3\2\2\2vw\b\21\2\2w\"\3\2\2\2xy\7\61\2\2yz\7,\2\2z~\3\2\2\2{"+
		"}\13\2\2\2|{\3\2\2\2}\u0080\3\2\2\2~\177\3\2\2\2~|\3\2\2\2\177\u0081\3"+
		"\2\2\2\u0080~\3\2\2\2\u0081\u0082\7,\2\2\u0082\u0083\7\61\2\2\u0083\u0084"+
		"\3\2\2\2\u0084\u0085\b\22\2\2\u0085$\3\2\2\2\u0086\u0087\t\5\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\u0089\b\23\2\2\u0089&\3\2\2\2\n\2SY_dfq~\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}