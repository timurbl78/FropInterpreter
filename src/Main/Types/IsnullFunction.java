package Main.Types;

import Main.Element.Element;

import java.util.List;

public class IsnullFunction extends Function {
    private final Element el;

    public IsnullFunction() {
        super(
                new Identifier("isnull"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public IsnullFunction(Element el) {
        super(
                new Identifier("isnull"),
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

        return new BooleanLiteral(a instanceof NullLiteral);
    }

    @Override
    public String toString() {
        return String.format("{\"isnull\": {\"Element1\": %s}}",
                this.el);
    }
}
