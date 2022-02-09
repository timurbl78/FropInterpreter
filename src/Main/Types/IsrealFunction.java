package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IsrealFunction extends Function {
    private final Element el;

    public IsrealFunction(Element el) {
        super("isreal", SubTokens.TOK_EQUAL);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"isreal\": {\"Element\": %s}}",
                this.el);
    }
}
