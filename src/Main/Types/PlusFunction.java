package Main.Types;

import Main.Element.Element;

import java.util.List;

public class PlusFunction extends Function {
    private final Element el1;
    private final Element el2;

    public PlusFunction() {
        super(
                new Identifier("plus"),
                List.of(new Identifier("el1"), new Identifier("el2")),
                new ElementsList()
        );

        this.el1 = null;
        this.el2 = null;
    }

    public PlusFunction(Element el1, Element el2) {
        super(
                new Identifier("plus"),
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

        if (a instanceof IntegerLiteral && b instanceof IntegerLiteral) {
            return new IntegerLiteral(((IntegerLiteral) a).getValue() + ((IntegerLiteral) b).getValue());
        } else if (a instanceof RealLiteral && b instanceof RealLiteral) {
            return new RealLiteral(((RealLiteral) a).getValue() + ((RealLiteral) b).getValue());
        } else if (a instanceof RealLiteral && b instanceof IntegerLiteral) {
            return new RealLiteral(((RealLiteral) a).getValue() + ((IntegerLiteral) b).getValue());
        } else if (a instanceof IntegerLiteral && b instanceof RealLiteral) {
            return new RealLiteral(((IntegerLiteral) a).getValue() + ((RealLiteral) b).getValue());
        } else {
            throw new Error("Incorrect types");
        }
    }

    @Override
    public String toString() {
        return String.format("{\"plus\": {\"Element1\": %s, \"Element2\": %s}}",
                this.el1, this.el2);
    }
}
