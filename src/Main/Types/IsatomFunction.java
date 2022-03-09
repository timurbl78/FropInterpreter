package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IsatomFunction extends Function {
    private final Element el;

    public IsatomFunction() {
        super(
                new Identifier("isatom"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }


    public IsatomFunction(Element el) {
        super(
                new Identifier("isatom"),
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

        return new BooleanLiteral(a instanceof Identifier);
    }

    @Override
    public String toString() {
        return String.format("{\"isatom\": {\"Element\": %s}}",
                this.el);
    }
}
