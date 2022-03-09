package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IsrealFunction extends Function {
    private final Element el;

    public IsrealFunction() {
        super(
                new Identifier("isreal"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public IsrealFunction(Element el) {
        super(
                new Identifier("isreal"),
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

        return new BooleanLiteral(a instanceof RealLiteral);
    }

    @Override
    public String toString() {
        return String.format("{\"isreal\": {\"Element\": %s}}",
                this.el);
    }
}
