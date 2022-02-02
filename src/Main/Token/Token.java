package Main.Token;

import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class Token {
    private Span span;
    private int code;
    private SubTokens subToken;
    private Tokens token;

    public Token(Tokens token, SubTokens subToken, Span span, int code) {
        this.span = span;
        this.code = code;
        this.token = token;
        this.subToken = subToken;
    }

    public Span getSpan() {
        return span;
    }

    public int getCode() {
        return code;
    }

    public SubTokens getSubToken() {
        return subToken;
    }

    public Tokens getToken() {
        return token;
    }
}

