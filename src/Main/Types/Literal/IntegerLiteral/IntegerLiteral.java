package Main.Types.Literal.IntegerLiteral;

import Main.Types.Literal.Literal;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;

public class IntegerLiteral extends Literal {
    static int code = 2;
    private int value;

    public IntegerLiteral(int value, Span span) {
        super(SubTokens.TOK_INTEGER_LITERAL, span, code);

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
