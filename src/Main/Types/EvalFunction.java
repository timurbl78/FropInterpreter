package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

import java.util.List;

public class EvalFunction extends Function {
    private final Element el;

    public EvalFunction() {
        super(
                new Identifier("eval"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public EvalFunction(Element el) {
        super(
                new Identifier("eval"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = el;
    }

    public Element calc(List<Element> list) {
        if (list.size() != 1) {
            throw new Error("Invalid number of arguments. Need 2");
        }

        return list.get(0);
    }

    @Override
    public String toString() {
        return String.format("{\"eval\": {\"Element\": %s}}",
                this.el);
    }
}
