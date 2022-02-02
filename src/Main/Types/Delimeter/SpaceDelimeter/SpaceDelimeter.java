package Main.Types.Delimeter.SpaceDelimeter;

import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Types.Delimeter.Delimeter;

public class SpaceDelimeter extends Delimeter {
    static int code = 8;
    private String value = " ";

    public SpaceDelimeter(Span span) {
        super(SubTokens.TOK_SPACE_DELIMETER, span, code);
    }
    
    public String getValue() {
        return value;
    }
}
