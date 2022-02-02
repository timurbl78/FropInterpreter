package Main.Types.Literal.RealLiteral;

import Main.Types.Literal.Literal;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;

public class RealLiteral extends Literal {
    static int code = 4;
    private double value;

    public RealLiteral(double value, Span span) {
        super(SubTokens.TOK_REAL_LITERAL, span, code);

        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
