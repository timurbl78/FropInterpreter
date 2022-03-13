package Main.Interpreter;

import Main.Element.Element;
import Main.Types.FuncSpecialForm;

import java.util.HashMap;
import java.util.Objects;

public class SymbolTable {
    private final SymbolTable parent;
    private final HashMap<String, Element> table;

    public SymbolTable() {
        this.table = new HashMap<>();
        this.parent = null;
    }

    public SymbolTable(SymbolTable parent) {
        this.table = new HashMap<>();
        this.parent = parent;
    }

    public void define(FuncSpecialForm f) {
        table.put(f.getName(), f);
    }

    public void define(String s, Element el) {
        table.put(s, el);
    }

    public void defineLookup(String s, Element el) {
        SymbolTable curr = this;

        while (curr != null && !curr.table.containsKey(s)) {
            curr = curr.parent;
        }

        Objects.requireNonNullElse(curr, this).define(s, el);
    }

    public Element lookup(String name) {
        Element el = table.get(name);
        if (el == null && parent != null){
            el = parent.lookup(name);
        }
        return el;
    }

    public boolean has(String name) {
        return this.table.containsKey(name);
    }
}
