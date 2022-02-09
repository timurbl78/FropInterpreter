package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class GreatereqFunction extends Function {
    private final Element el1;
    private final Element el2;

    public GreatereqFunction(Element el1, Element el2) {
        super("greatereq", SubTokens.TOK_GREATEREQ);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"greatereq\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
