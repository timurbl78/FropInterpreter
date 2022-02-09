package Main.Position;

public class Position {
    public int line = 1;
    public int column = 1;

    public Position() {
        line = 1;
        column = 1;
    }

    public Position(int l, int c) {
        line = l;
        column = c;
    }

    public Position(Position p) {
        line = p.line;
        column = p.column;
    }

    public void set(Position p) {
        line = p.line;
        column = p.column;
    }

    public boolean equals(Position p) {
        return p.line == line && p.column == column;
    }

    public String toString() {
        return Integer.toString(line) + "." + Integer.toString(column);
    }

    public int line() {
        return line;
    }

    public int column() {
        return column;
    }
}
