package Main.Interpreter;

import Main.Element.Element;
import Main.Types.*;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Interpreter {
    private final SymbolTable rootTable = new SymbolTable();
    public final Stack<StackTraceElement> stackTrace = new Stack<>();
    private Boolean isBreak = false;
    private Element returnedValue = null;

    public Interpreter() {
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

    public Element calc(Element el) {
        return calc(el, rootTable);
    }

    private Element calc(Element el, SymbolTable scope) {
        if (this.isBreak || this.returnedValue != null) {
            return null;
        }

        if (el instanceof QuoteSpecialForm quote) {
            return quote.getValue();
        } else if (el instanceof SetqSpecialForm setq) {
            scope.defineLookup(setq.id.value, calc(setq.el, scope));
        } else if (el instanceof FuncSpecialForm func) {
            scope.define(func);
        } else if (el instanceof ProgSpecialForm prog) {
            // TODO: implement
            return prog;
        } else if (el instanceof CondSpecialForm cond) {
            Element boolResult = calc(cond.el1, scope);
            if (boolResult instanceof BooleanLiteral) {
                if (((BooleanLiteral) boolResult).getValue()) {
                    return calc(cond.el2, scope);
                } else {
                    return calc(cond.el3, scope);
                }
            } else {
                throw new Error("The result should be boolean");
            }
        } else if (el instanceof WhileSpecialForm whl) {
            while (!this.isBreak && this.returnedValue == null) {
                Element cond = calc(whl.el1, scope);
                if (cond instanceof BooleanLiteral bool) {
                    if (bool.getValue()) {
                        calc(whl.el2, scope);
                    } else {
                        return null;
                    }
                } else {
                    throw new Error("The result should be boolean");
                }
            }
            this.isBreak = false;
        } else if (el instanceof NullLiteral n) {
            return n;
        } else if (el instanceof ReturnSpecialForm retrn) {
            this.returnedValue = calc(retrn.el, scope);
        } else if (el instanceof BreakSpecialForm) {
            this.isBreak = true;
        } else if (el instanceof ElementsList list) {
            ElementsList clone = list.clone();
            if (clone.isEmpty()) return clone;

            clone.set(0, calc(clone.getFirst(), scope));
            Element first = clone.getFirst();

            if (first instanceof LambdaSpecialForm f) {
                stackTrace.add(new StackTraceElement("", f.getName(), "", f.getLine()));
            }
            for (int i = 1; i < clone.size(); i++) {
                clone.set(i, calc(clone.get(i), scope));
            }
            if (first instanceof LambdaSpecialForm f) {
                clone.removeFirst();

                if (f instanceof EvalFunction ev) {
                    Element result = calc(ev.calc(clone), scope);
                    stackTrace.pop();
                    return result;
                } else if (f instanceof Builtin b) {
                    Element result = b.calc(clone);
                    stackTrace.pop();
                    return result;
                } else {
                    SymbolTable localScope = new SymbolTable(scope);

                    List<Identifier> argNames = f.getArgs();
                    for (int i = 0; i < argNames.size(); i++) {
                        localScope.define(argNames.get(i).value, clone.get(i));
                    }

                    Element result = calc(f.getEl(), localScope);
                    if (this.returnedValue != null) {
                        result = this.returnedValue;
                        this.returnedValue = null;
                    }
                    stackTrace.pop();
                    return result;
                }
            } else {
                return clone;
            }
        } else if (el instanceof Identifier id) {
            String name = id.value;
            return Objects.requireNonNullElse(scope.lookup(name), rootTable.lookup(name));
        } else {
            return el;
        }
        return null;
    }
}
