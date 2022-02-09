package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class IsnullFunction extends Function {
    private final Element el;

    public IsnullFunction(Element el) {
        super("isnull", SubTokens.TOK_ISNULL);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"isnull\": {\"Element1\": %s}}",
                this.el);
    }
}
