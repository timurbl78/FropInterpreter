package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class DivideFunction extends Function {
    private final Element el1;
    private final Element el2;

    public DivideFunction(Element el1, Element el2) {
        super("divide", SubTokens.TOK_DIVIDE);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"divide\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
