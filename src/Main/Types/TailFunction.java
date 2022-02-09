package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class TailFunction extends Function {
    private final Element el;

    public TailFunction(Element el) {
        super("tail", SubTokens.TOK_TAIL);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"tail\": {\"Element\": %s}}",
                this.el);
    }
}
