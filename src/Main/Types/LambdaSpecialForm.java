package Main.Types;

import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class LambdaSpecialForm extends SpecialForm {
    private final List<Identifier> args;
    private final Element el;

    public LambdaSpecialForm(List<Identifier> args, Element el) {
        super("lambda", SubTokens.TOK_LAMBDA);

        this.args = args;
        this.el = el;
    }

    @Override
    public String toString() {
        return String.format("{\"Lambda\": {\"Args\": %s, \"Element\": %s}}",
                this.args, this.el);
    }
}