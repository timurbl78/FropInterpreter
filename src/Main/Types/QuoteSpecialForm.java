package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class QuoteSpecialForm extends SpecialForm {
    private final Element el;

    public QuoteSpecialForm(Element el) {
        super("quote", SubTokens.TOK_QUOTE);

        this.el = el;
    }

    public Element getValue() {
        return this.el;
    }

    @Override
    public String toString() {
        return String.format("{\"Quote\": {\"Element\": %s}}", this.el);
    }
}
