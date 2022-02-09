package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class MinusFunction extends Function {
    private final Element el1;
    private final Element el2;

    public MinusFunction(Element el1, Element el2) {
        super("minus", SubTokens.TOK_MINUS);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"minus\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
