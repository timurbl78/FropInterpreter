package Main.Types;

import Main.Element.SubTokens.SubTokens;

public class IntegerLiteral extends Literal {
    private int value;

    public IntegerLiteral(int value) {
        super(SubTokens.TOK_INTEGER_LITERAL);

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{\"Integer\": \"%d\"}", this.value);
    }
}
