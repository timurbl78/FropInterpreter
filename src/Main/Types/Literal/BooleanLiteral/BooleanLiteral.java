package Main.Types.Literal.BooleanLiteral;

import Main.Types.Literal.Literal;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;

public class BooleanLiteral extends Literal {
    static int code = 1;
    private boolean value;

    public BooleanLiteral(String value, Span span) {
        super(BoolToSubToken(value), span, code);

        this.value = StringToBoolean(value);
    }

    private static SubTokens BoolToSubToken(String bool) {
        if (bool.equals("true")) {
            return SubTokens.TOK_TRUE_LITERAL;
        }
        return SubTokens.TOK_FALSE_LITERAL;
    }

    private static boolean StringToBoolean(String bool) {
        return bool.equals("true");
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }
}
