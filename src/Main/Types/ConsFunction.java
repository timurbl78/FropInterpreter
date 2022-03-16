package Main.Types;

import Main.Element.Element;

import java.util.List;

public class ConsFunction extends FuncSpecialForm implements Builtin {
    private final Element el1;
    private final Element el2;

    public ConsFunction() {
        super(
                new Identifier("cons"),
                List.of(new Identifier("el1"), new Identifier("el2")),
                new ElementsList()
        );

        this.el1 = null;
        this.el2 = null;
    }

    public ConsFunction(Element el1, Element el2) {
        super(
                new Identifier("cons"),
                List.of(new Identifier("el1"), new Identifier("el2")),
                new ElementsList()
        );

        this.el1 = el1;
        this.el2 = el2;
    }

    public Element calc(List<Element> list) {
        if (list.size() != 2) {
            throw new Error("Invalid number of arguments. Need 2");
        }

        Element a = list.get(0);
        Element b = list.get(1);

        if (b instanceof ElementsList) {
            ElementsList result = new ElementsList();
            result.addAll((ElementsList) b);
            result.addFirst(a);
            return result;
        } else {
            throw new Error("Incorrect types");
        }
    }

    @Override
    public String toString() {
        return String.format("{\"cons\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
