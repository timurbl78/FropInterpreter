package Main.Element.Span;

public class Span {
    private int lineNum;
    private int posBegin, posEnd;

    public Span(int lineNum, int posBegin, int posEnd) {
        this.lineNum = lineNum;
        this.posBegin = posBegin;
        this.posEnd = posEnd;
    }

    public int getLineNum() {
        return lineNum;
    }

    public void setLineNum(int lineNum) {
        this.lineNum = lineNum;
    }

    public int getPosBegin() {
        return posBegin;
    }

    public void setPosBegin(int posBegin) {
        this.posBegin = posBegin;
    }

    public int getPosEnd() {
        return posEnd;
    }

    public void setPosEnd(int posEnd) {
        this.posEnd = posEnd;
    }
}
