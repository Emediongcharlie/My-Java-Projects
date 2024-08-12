package turtleGraphics;

public class Position {
    int row = 0;
    int column = 0;
    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public void setRow(int numberOfSteps) {
        this.row += numberOfSteps;
    }
    public void setColumn(int numberOfSteps) {
        this.column += numberOfSteps;
    }

    @Override
    public String toString() {
        return "Position{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
