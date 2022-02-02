package Main.Types.SpecialForm;

import Main.Token.Token;
import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Token.Tokens.Tokens;

public class SpecialForm extends Token {
    static final int code = 12;

    public SpecialForm(SubTokens subToken, Span span) {
        super(Tokens.SPECIAL_FORM, subToken, span, code);
    }
}
