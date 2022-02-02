package Main.Types.Identifier;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Identifier extends Token {
    static final int code = 11;
    private String value;

    public Identifier(String value, Span span) {
        super(Tokens.IDENTIFIER, SubTokens.TOK_IDENTIFIER, span, code);

        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
