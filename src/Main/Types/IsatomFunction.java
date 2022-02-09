package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IsatomFunction extends Function {
    private final Element el;

    public IsatomFunction(Element el) {
        super("isatom", SubTokens.TOK_ISATOM);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"isatom\": {\"Element\": %s}}",
                this.el);
    }
}
