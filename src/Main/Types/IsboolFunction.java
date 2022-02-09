package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IsboolFunction extends Function {
    private final Element el;

    public IsboolFunction(Element el) {
        super("isbool", SubTokens.TOK_ISBOOL);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"isbool\": {\"Element\": %s}}",
                this.el);
    }
}
