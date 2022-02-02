package Main.Types.Bracket;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Bracket extends Token {
    public Bracket(SubTokens subToken, Span span, int code) {
        super(Tokens.LIST_BRACKET, subToken, span, code);
    }
}
