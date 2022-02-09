package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IsintFunction extends Function {
    private final Element el;

    public IsintFunction(Element el) {
        super("isint", SubTokens.TOK_ISINT);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"isint\": {\"Element\": %s}}",
                this.el);
    }
}
