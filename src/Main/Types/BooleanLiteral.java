package Main.Types;

import Main.Element.SubTokens.SubTokens;

public class BooleanLiteral extends Literal {
    private boolean value;

    public BooleanLiteral(Boolean value) {
        super(SubTokens.TOK_BOOLEAN_LITERAL);

        this.value = value;
    }

    public BooleanLiteral(String value) {
        super(SubTokens.TOK_BOOLEAN_LITERAL);

        this.value = StringToBoolean(value);
    }

    private boolean StringToBoolean(String bool) {
        return bool.equals("true");
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{\"Boolean\": \"%b\"}", this.value);
    }
}
