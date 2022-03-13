package Main.Types;

import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

public class LambdaSpecialForm extends SpecialForm {
    private final List<Identifier> args;
    private final Element el;
    private final int line;

    public LambdaSpecialForm(List<Identifier> args, Element el, int line) {
        super("lambda", SubTokens.TOK_LAMBDA);

        this.args = args;
        this.el = el;
        this.line = line;
    }

    public String getName() {
        return "Qwewefsd";
    }

    public List<Identifier> getArgs() {
        return this.args;
    }

    public Element getEl() {
        return this.el;
    }

    public int getLine() {
        return this.line;
    }

    @Override
    public String toString() {
        return String.format("{\"Lambda\": {\"Args\": %s, \"Element\": %s}}",
                this.args, this.el);
    }
}