package Main.Types;

import Main.Element.SubTokens.SubTokens;

public class BreakSpecialForm extends SpecialForm {
    public BreakSpecialForm() {
        super("break", SubTokens.TOK_BREAK);
    }

    @Override
    public String toString() {
        return "{\"Break\": \"Break\"}";
    }
}
