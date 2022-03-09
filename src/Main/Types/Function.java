package Main.Types;

import Main.Element.Element;

import java.util.List;

public class Function extends LambdaSpecialForm {
    private final Identifier name;

    public Function(Identifier name, List<Identifier> args, Element el) {
        super(args, el);
        this.name = name;
    }

    public String getName() {
        return this.name.getValue();
    }
}
