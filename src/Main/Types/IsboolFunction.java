package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IsboolFunction extends Function {
    private final Element el;

    public IsboolFunction() {
        super(
                new Identifier("isbool"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public IsboolFunction(Element el) {
        super(
                new Identifier("isbool"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = el;
    }

    public Element calc(List<Element> list) {
        if (list.size() != 1) {
            throw new Error("Invalid number of arguments. Need 2");
        }

        Element a = list.get(0);

        return new BooleanLiteral(a instanceof BooleanLiteral);
    }

    @Override
    public String toString() {
        return String.format("{\"isbool\": {\"Element\": %s}}",
                this.el);
    }
}
