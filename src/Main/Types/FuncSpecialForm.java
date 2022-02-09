package Main.Types;

import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class FuncSpecialForm extends SpecialForm {
    private final Identifier id;
    private final List<Identifier> args;
    private final Element el;

    public FuncSpecialForm(Identifier id, List<Identifier> args, Element el) {
        super("func", SubTokens.TOK_FUNC);

        this.id = id;
        this.args = args;
        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"Func\": {\"Identifier\": %s, \"List\": %s, \"Element\": %s}}",
                this.id, this.args, this.el);
    }
}