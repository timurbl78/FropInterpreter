package Main.Types.Literal;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Literal extends Token {
    public Literal(SubTokens subToken, Span span, int code) {
        super(Tokens.LITERAL, subToken, span, code);
    }
}
