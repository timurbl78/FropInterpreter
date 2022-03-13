package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class SpecialForm implements Element {
    public Tokens token = Tokens.IDENTIFIER;
    public SubTokens subToken;

    public String value;

    public SpecialForm(String value, SubTokens subToken) {
        this.value = value;
        this.subToken = subToken;
    }

    @Override
    public String toString() {
        return String.format("{\"SpecialForm\": \"%s\"}",
                this.value);
    }
}
