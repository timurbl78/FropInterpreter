package Main.Types.Delimeter;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Delimeter extends Token {
    public Delimeter(SubTokens subToken, Span span, int code) {
        super(Tokens.DELIMETER, subToken, span, code);
    }
}
