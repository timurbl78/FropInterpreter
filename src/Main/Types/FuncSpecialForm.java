package Main.Types;

import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class FuncSpecialForm extends LambdaSpecialForm {
    private final Identifier name;
    private final List<Identifier> args;
    private final Element el;

    public FuncSpecialForm(Identifier name, List<Identifier> args, Element el) {
        super(args, el, 0);

        this.name = name;
        this.args = args;
        this.el = el;
    }

    public FuncSpecialForm(Identifier name, List<Identifier> args, Element el, int line) {
        super(args, el, line);

        this.name = name;
        this.args = args;
        this.el = el;
    }

    public String getName() {
        return this.name.value;
    }

    @Override
    public String toString() {
        return String.format("{\"Func\": {\"Identifier\": %s, \"List\": %s, \"Element\": %s}}",
                this.name, this.args, this.el);
    }
}