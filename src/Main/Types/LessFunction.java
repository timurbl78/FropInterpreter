package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class LessFunction extends Function {
    private final Element el1;
    private final Element el2;

    public LessFunction(Element el1, Element el2) {
        super("less", SubTokens.TOK_LESS);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"less\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
