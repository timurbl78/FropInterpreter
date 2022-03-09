package Main.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.regex.Pattern;

import Main.Element.Element;
import Main.Position.Position;
import Main.PositionReader.PositionReader;
import Main.Types.*;

class MyLexer implements Main.parser.Parser.Lexer {
    private final Pattern INTEGER_PATTERN = Pattern.compile("[+\\-]?[0-9]+");
    private final Pattern REAL_PATTERN = Pattern.compile("[+\\-]?[0-9]*\\.[0-9]+");
    private final Pattern BOOLEAN_PATTERN = Pattern.compile("(true|false)");;
    private final Pattern NULL_PATTERN = Pattern.compile("null");
    private final Pattern IDENTIFIER_PATTERN = Pattern.compile("[a-zA-Z][a-zA-Z0-9]*");

    private final HashMap<String, Integer> SPECIAL_FORMS_TO_TOKENS = new HashMap<>() {{
        put("quote", TOK_QUOTE);
        put("setq", TOK_SETQ);
        put("func", TOK_FUNC);
        put("lambda", TOK_LAMBDA);
        put("prog", TOK_PROG);
        put("cond", TOK_COND);
        put("while", TOK_WHILE);
        put("return", TOK_RETURN);
        put("break", TOK_BREAK);
    }};

    StreamTokenizer st;
    PositionReader reader;
  
    Position start = new Position(1, 0);
    Position end = new Position(1, 0);
    private Element yylval;
  
    private static final int QUOTE_CHARACTER = '\'';
    private static final int OPEN_BRACKET_CHARACTER = '(';
    private static final int CLOSE_BRACKET_CHARACTER = ')';

    public MyLexer(String pathToFile) throws FileNotFoundException {
        File file = new File(pathToFile);
        InputStream is = new FileInputStream(file);
        reader = new PositionReader(new InputStreamReader(is));
        st = new StreamTokenizer(reader);
  
        st.ordinaryChar('\'');
    }

    /**
     * The location of the last token read.
     * Implemented with getStartPos and getEndPos in pull parsers.
     */
    public Parser.Location getLocation() {
        return new Parser.Location(new Position(start), new Position(end));
    }
  
    /**
     * Build and emit a syntax error message.
     */
    public void reportSyntaxError(Parser.Context ctx) {
      System.err.print(ctx.getLocation() + ": syntax error");
      {
        final int TOKENMAX = 10;
        Parser.SymbolKind[] arg = new Parser.SymbolKind[TOKENMAX];
        int n = ctx.getExpectedTokens(arg, TOKENMAX);
        for (int i = 0; i < n; ++i)
          System.err.print((i == 0 ? ": expected " : " or ")
                           + arg[i].getName());
      }
      {
        Parser.SymbolKind lookahead = ctx.getToken();
        if (lookahead != null)
          System.err.print(" before " + lookahead.getName());
      }
      System.err.println("");
    }
  
    /**
     * Emit an error referring to the given location in a user-defined way.
     *
     * @@param loc The location of the element to which the
     *                error message is related.
     * @@param msg The string for the error message.
     */
    public void yyerror(Parser.Location loc, String msg) {
        if (loc == null) {
            System.err.println(msg);
        } else {
            System.err.println(loc + ": " + msg);
        }
    }
  
    /**
     * The value of the last token read.  Called getLVal in pull parsers.
     */
    public Element getValue() {
      return yylval;
    }
  
    /**
     * Fetch the next token.  Called yylex in pull parsers.
     */
    public int getToken() throws IOException {
        start.set(reader.getPosition());
        int ttype = st.nextToken();
        end.set(reader.getPosition());

        String value;
  
        switch (ttype) {
            case StreamTokenizer.TT_EOF:
                return YYEOF;
            case StreamTokenizer.TT_NUMBER:
                end.set(reader.getPreviousPosition());
                value = String.valueOf(st.nval);
                if (INTEGER_PATTERN.matcher(value).matches()) {
                    yylval = new IntegerLiteral(Integer.parseInt(value));
                    return TOK_INTEGER_LITERAL;
                } else if (REAL_PATTERN.matcher(value).matches()) {
                    yylval = new RealLiteral(Double.parseDouble(value));
                    return TOK_REAL_LITERAL;
                }
                yylval = new Invalid(value);
                return YYUNDEF;
            case StreamTokenizer.TT_WORD:
                end.set(reader.getPreviousPosition());
                value = String.valueOf(st.sval);

                if (BOOLEAN_PATTERN.matcher(value).matches()) {
                    yylval = new BooleanLiteral(value);
                    return TOK_BOOLEAN_LITERAL;
                } else if (NULL_PATTERN.matcher(value).matches()) {
                    yylval = new NullLiteral();
                    return TOK_NULL_LITERAL;
                } else if (SPECIAL_FORMS_TO_TOKENS.containsKey(value)) {
                    return SPECIAL_FORMS_TO_TOKENS.get(value);
                } else if (IDENTIFIER_PATTERN.matcher(value).matches()) {
                    yylval = new Identifier(value);
                    return TOK_IDENTIFIER;
                } else {
                    yylval = new Invalid(value);
                    return YYUNDEF;
                }
            case QUOTE_CHARACTER:
                return TOK_QUOTE_SIGN;
            case OPEN_BRACKET_CHARACTER:
                return TOK_OPEN_BRACKET;
            case CLOSE_BRACKET_CHARACTER:
                return TOK_CLOSE_BRACKET;
            default:
                yylval = new Invalid(String.valueOf(ttype));
                return YYUNDEF;
        }
    }
}
