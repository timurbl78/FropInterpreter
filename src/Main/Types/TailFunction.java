package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

import java.util.List;

public class TailFunction extends FuncSpecialForm implements Builtin {
    private final Element el;

    public TailFunction() {
        super(
                new Identifier("tail"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public TailFunction(Element el) {
        super(
                new Identifier("tail"),
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

        if (a instanceof ElementsList ) {
            return new ElementsList(((ElementsList) a).subList(1, ((ElementsList) a).size()));
        } else {
            throw new Error("Incorrect types");
        }
    }

    @Override
    public String toString() {
        return String.format("{\"tail\": {\"Element\": %s}}",
                this.el);
    }
}
