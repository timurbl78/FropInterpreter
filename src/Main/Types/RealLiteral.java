package Main.Types;

import Main.Element.SubTokens.SubTokens;

public class RealLiteral extends Literal {
    private double value;

    public RealLiteral(double value) {
        super(SubTokens.TOK_REAL_LITERAL);

        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return String.format("{\"Real\": \"%f\"}", this.value);
    }
}
