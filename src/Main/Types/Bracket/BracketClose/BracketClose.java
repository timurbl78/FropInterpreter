package Main.Types.Bracket.BracketClose;

import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Types.Bracket.Bracket;

public class BracketClose extends Bracket {
    static int code = 5;
    private String value = ")";

    public BracketClose(Span span) {
        super(SubTokens.TOK_CLOSE_BRACKET, span, code);
    }
    
    public String getValue() {
        return value;
    }
}
