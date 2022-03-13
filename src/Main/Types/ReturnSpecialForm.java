package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class ReturnSpecialForm extends SpecialForm {
    public final Element el;

    public ReturnSpecialForm(Element el) {
        super("return", SubTokens.TOK_RETURN);

        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"Return\": {\"Element\": %s}}", this.el);
    }
}