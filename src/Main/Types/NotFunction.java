package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class NotFunction extends Function {
    private final Element el;

    public NotFunction(Element el) {
        super("not", SubTokens.TOK_NOT);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"not\": {\"Element\": %s}}",
                this.el);
    }
}
