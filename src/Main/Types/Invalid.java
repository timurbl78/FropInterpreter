package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class Invalid implements Element {
    public Tokens token = Tokens.IDENTIFIER;
    public SubTokens subToken = SubTokens.TOK_INVALID;

    private String value;

    public Invalid(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.format("{\"Invalid\": \"%s\"}", this.value);
    }
}
