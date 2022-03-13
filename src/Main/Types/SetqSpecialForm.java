package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class SetqSpecialForm extends SpecialForm {
    public final Identifier id;
    public final Element el;

    public SetqSpecialForm(Identifier id, Element el) {
        super("setq", SubTokens.TOK_SETQ);

        this.id = id;
        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"Setq\": {\"Identifier\": %s, \"Element\": %s}}", this.id, this.el);
    }
}