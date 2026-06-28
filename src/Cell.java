public class Cell {
    int row, col;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Cell)) return false;
        Cell other = (Cell) obj;
        return this.row == other.row && this.col == other.col;
    }
    public int hashCode() {
        return 31 * row + col;
    }
    public String toString() {
        return "(" + row + ", " + col + ")";
    }
}