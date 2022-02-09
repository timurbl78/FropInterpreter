package Main.Types;

import Main.Element.Element;
import Main.Element.SubTokens.SubTokens;
import Main.Element.Tokens.Tokens;

public class Literal implements Element {
    public Tokens token = Tokens.LITERAL;
    public SubTokens subToken;

    public Literal(SubTokens subToken) {
        this.subToken = subToken;
    }
}
