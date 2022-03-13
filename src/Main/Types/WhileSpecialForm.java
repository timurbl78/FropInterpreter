package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class WhileSpecialForm extends SpecialForm {
    public final Element el1;
    public final Element el2;

    public WhileSpecialForm(Element el1, Element el2) {
        super("while", SubTokens.TOK_WHILE);

        this.el1 = el1;
        this.el2 = el2;
    }

    @Override
    public String toString() {
        return String.format("{\"While\": {\"Element1\": %s, \"Element2\": %s}}", this.el1, this.el2);
    }
}