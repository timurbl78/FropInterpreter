package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class ConsFunction extends Function {
    private final Element el1;
    private final Element el2;

    public ConsFunction(Element el1, Element el2) {
        super("cons", SubTokens.TOK_CONS);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"cons\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
