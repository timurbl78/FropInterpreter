package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IsintFunction extends Function {
    private final Element el;

    public IsintFunction() {
        super(
                new Identifier("isint"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public IsintFunction(Element el) {
        super(
                new Identifier("isint"),
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

        return new BooleanLiteral(a instanceof IntegerLiteral);
    }

    @Override
    public String toString() {
        return String.format("{\"isint\": {\"Element\": %s}}",
                this.el);
    }
}
