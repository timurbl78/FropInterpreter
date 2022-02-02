package Main.Types.Function;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Function extends Token {
    static int code = 10;

    public Function(SubTokens subToken, Span span) {
        super(Tokens.FUNCTION, subToken, span, code);
    }
}
