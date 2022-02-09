package Main.Types;

import Main.Element.SubTokens.SubTokens;

public class NullLiteral extends Literal {
    private Object value = null;

    public NullLiteral() {
        super(SubTokens.TOK_NULL_LITERAL);
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "{\"Null\": \"Null\"}";
    }
}
