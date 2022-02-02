package Main.Types.Literal.NullLiteral;

import Main.Types.Literal.Literal;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;

public class NullLiteral extends Literal {
    static int code = 3;
    private Object value = null;

    public NullLiteral(Span span) {
        super(SubTokens.TOK_NULL_LITERAL, span, code);
    }

    public Object getValue() {
        return value;
    }
}
