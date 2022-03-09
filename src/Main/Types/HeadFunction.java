package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;

import java.util.List;

public class HeadFunction extends Function {
    private final Element el;

    public HeadFunction() {
        super(
                new Identifier("head"),
                List.of(new Identifier("el")),
                new ElementsList()
        );

        this.el = null;
    }

    public HeadFunction(Element el) {
        super(
                new Identifier("head"),
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
            return ((ElementsList) a).getFirst();
        } else {
            throw new Error("Incorrect types");
        }
    }

    @Override
    public String toString() {
        return String.format("{\"head\": {\"Element\": %s}}",
                this.el);
    }
}
