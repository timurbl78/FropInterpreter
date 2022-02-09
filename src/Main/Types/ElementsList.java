package Main.Types;

import java.util.LinkedList;
import java.util.List;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class ElementsList extends LinkedList<Element> implements Element {
    // TODO: token

    public ElementsList() {
        super();
    }

    public ElementsList(Element elem) {
        this();
        add(elem);
    }

    public ElementsList(Element elem1, Element elem2) {
        this(elem1);
        add(elem2);
    }

    public ElementsList(List<Element> list) {
        this.addAll(list);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("{\"ElementsList\": [");

        for (int i = 0; i < this.size(); i++) {
            str.append(this.get(i).toString());
            str.append(",");
        }

        str.replace(str.length() - 1, str.length(), "]}");

        return str.toString();
    }

    public ElementsList clone() {
        return (ElementsList) super.clone();
    }
}
