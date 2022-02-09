package Main.Types;

import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class ProgSpecialForm extends SpecialForm {
    private final List<Identifier> args;
    private final Element el;

    public ProgSpecialForm(List<Identifier> args, Element el) {
        super("prog", SubTokens.TOK_PROG);

        this.args = args;
        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"Prog\": {\"Args\": %s, \"Element\": %s}}",
                this.args, this.el);
    }
}