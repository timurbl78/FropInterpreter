package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class Identifier implements Element {
    public Tokens token = Tokens.IDENTIFIER;
    public SubTokens subToken;

    private String value;

    public Identifier(String value, SubTokens subToken) {
        this.value = value;
        this.subToken = subToken;
    }

    public Identifier(String value) {
        this.value = value;
        this.subToken = SubTokens.TOK_IDENTIFIER;
    }

    @Override
    public String toString() {
        return String.format("{\"Identifier\": \"%s\"}",
                this.value);
    }
}
