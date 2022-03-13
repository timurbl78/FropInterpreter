package Main.Types;

import Main.Element.Element;

import java.util.List;

public interface Builtin {
    public Element calc(List<Element> argValues);
}
