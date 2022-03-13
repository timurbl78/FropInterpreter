package Main.Types;

import Main.Element.Element;

import java.util.List;

public class NotFunction extends FuncSpecialForm implements Builtin {
    private final Element el;

    public NotFunction() {
        super(
                new Identifier("not"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public NotFunction(Element el) {
        super(
                new Identifier("not"),
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

        if (a instanceof BooleanLiteral) {
            return new BooleanLiteral(!((BooleanLiteral) a).getValue());
        } else {
            throw new Error("Incorrect types");
        }
    }

    @Override
    public String toString() {
        return String.format("{\"not\": {\"Element\": %s}}",
                this.el);
    }
}
