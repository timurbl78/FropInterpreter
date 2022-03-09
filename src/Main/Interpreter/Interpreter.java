package Main.Interpreter;

import Main.Types.*;

public class Interpreter {
    private final SymbolTable rootTable;

    public Interpreter() {
        rootTable = new SymbolTable();

        rootTable.define(new PlusFunction());
        rootTable.define(new MinusFunction());
        rootTable.define(new TimesFunction());
        rootTable.define(new DivideFunction());

        rootTable.define(new HeadFunction());
        rootTable.define(new TailFunction());
        rootTable.define(new ConsFunction());

        rootTable.define(new EqualFunction());
        rootTable.define(new NonequalFunction());
        rootTable.define(new LessFunction());
        rootTable.define(new LesseqFunction());
        rootTable.define(new GreaterFunction());
        rootTable.define(new GreatereqFunction());

        rootTable.define(new IsintFunction());
        rootTable.define(new IsrealFunction());
        rootTable.define(new IsboolFunction());
        rootTable.define(new IsnullFunction());
        rootTable.define(new IsatomFunction());
        rootTable.define(new IslistFunction());

        rootTable.define(new AndFunction());
        rootTable.define(new OrFunction());
        rootTable.define(new XorFunction());
        rootTable.define(new NotFunction());

        rootTable.define(new EvalFunction());
    }
}
