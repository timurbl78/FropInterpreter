package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class HeadFunction extends Function {
    private final Element el;

    public HeadFunction(Element el) {
        super("head", SubTokens.TOK_HEAD);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"head\": {\"Element\": %s}}",
                this.el);
    }
}
