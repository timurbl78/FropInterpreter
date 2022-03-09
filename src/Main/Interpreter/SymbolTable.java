package Main.Interpreter;

import Main.Element.Element;
import Main.Types.Function;

import java.util.HashMap;

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

    public void define(Function f) {
        table.put(f.getName(), f);
    }

    public boolean has(String name) {
        return this.table.containsKey(name);
    }
}
