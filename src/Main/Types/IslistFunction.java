package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IslistFunction extends Function {
    private final Element el;

    public IslistFunction(Element el) {
        super("islist", SubTokens.TOK_ISLIST);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"islist\": {\"Element\": %s}}",
                this.el);
    }
}
