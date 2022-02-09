package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class EvalFunction extends Function {
    private final Element el;

    public EvalFunction(Element el) {
        super("eval", SubTokens.TOK_EVAL);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"eval\": {\"Element\": %s}}",
                this.el);
    }
}
