package Main.Types.Bracket.BracketOpen;

import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Types.Bracket.Bracket;

public class BracketOpen extends Bracket {
    static int code = 6;
    private String value = "(";

    public BracketOpen(Span span) {
        super(SubTokens.TOK_OPEN_BRACKET, span, code);
    }
    
    public String getValue() {
        return value;
    }
}
