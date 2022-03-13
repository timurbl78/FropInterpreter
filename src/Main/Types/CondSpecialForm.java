package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class CondSpecialForm extends SpecialForm {
    public final Element el1;
    public final Element el2;
    public final Element el3;

    public CondSpecialForm(Element el1, Element el2) {
        super("cond", SubTokens.TOK_COND);

        this.el1 = el1;
        this.el2 = el2;
        this.el3 = null;
    }

    public CondSpecialForm(Element el1, Element el2, Element el3) {
        super("cond", SubTokens.TOK_COND);

        this.el1 = el1;
        this.el2 = el2;
        this.el3 = el3;
    }

    @Override
    public String toString() {
        return String.format("{\"Cond\": {\"Element1\": %s, \"Element2\": %s, \"Element3\": %s}}",
                this.el1, this.el2, this.el3);
    }
}
