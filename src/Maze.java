import java.util.List;

public class Maze {
    private char[][] grid;
    private int rows, cols;
    private Cell start, exit;

    public Maze(char[][] inputGrid) {
        this.rows = inputGrid.length;
        this.cols = inputGrid[0].length;
        this.grid = new char[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = inputGrid[r][c];
                if (grid[r][c] == 'S') start = new Cell(r, c);
                if (grid[r][c] == 'E') exit  = new Cell(r, c);
            }
        }

        if (start == null) throw new IllegalArgumentException("Error: No Start (S) found in the maze!");
        if (exit  == null) throw new IllegalArgumentException("Error: No Exit (E) found in the maze!");
    }

    public boolean isWalkable(int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols) return false;
        return grid[r][c] != '1';
    }
    public void markPath(List<Cell> path) {
        for (Cell cell : path) {
            char current = grid[cell.row][cell.col];
            if (current != 'S' && current != 'E') {
                grid[cell.row][cell.col] = '*';
            }
        }
    }
    public void print() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                System.out.print(grid[r][c]);
                if (c < cols - 1) System.out.print(" ");
            }
            System.out.println();
        }
    }

    public Cell getStart() {
        return start;
    }
    public Cell getExit()  {
        return exit;
    }
    public int  getRows()  {
        return rows;
    }
    public int  getCols()  {
        return cols;
    }
}