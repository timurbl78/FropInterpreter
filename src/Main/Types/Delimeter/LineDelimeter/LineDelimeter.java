package Main.Types.Delimeter.LineDelimeter;

import Main.Token.Span.Span;
import Main.Token.SubTokens.SubTokens;
import Main.Types.Delimeter.Delimeter;

public class LineDelimeter extends Delimeter {
    static int code = 7;
    private String value = "\n";

    public LineDelimeter(Span span) {
        super(SubTokens.TOK_LINE_DELIMETER, span, code);
    }

    public String getValue() {
        return value;
    }
}
