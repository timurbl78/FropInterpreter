package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IslistFunction extends Function {
    private final Element el;

    public IslistFunction() {
        super(
                new Identifier("islist"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public IslistFunction(Element el) {
        super(
                new Identifier("islist"),
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

        return new BooleanLiteral(a instanceof ElementsList);
    }

    @Override
    public String toString() {
        return String.format("{\"islist\": {\"Element\": %s}}",
                this.el);
    }
}
