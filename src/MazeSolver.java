import java.util.*;

public class MazeSolver {
    private Maze maze;
    private int[] dr = {-1,  1,  0, 0};
    private int[] dc = { 0,  0, -1, 1};

    public MazeSolver(Maze maze) {
        this.maze = maze;
    }
    public List<Cell> solve() {
        Cell start = maze.getStart();
        Cell exit  = maze.getExit();

        Queue<Cell> queue   = new LinkedList<>();
        Map<Cell, Cell> parent = new HashMap<>();

        queue.add(start);
        parent.put(start, null);

        while (!queue.isEmpty()) {
            Cell current = queue.poll();

            if (current.equals(exit)) {
                return reconstructPath(parent, exit);
            }
            for (int d = 0; d < 4; d++) {
                int nr = current.row + dr[d];
                int nc = current.col + dc[d];
                Cell neighbor = new Cell(nr, nc);
                if (maze.isWalkable(nr, nc) && !parent.containsKey(neighbor)) {
                    parent.put(neighbor, current);
                    queue.add(neighbor);
                }
            }
        }
        return null;
    }


    private List<Cell> reconstructPath(Map<Cell, Cell> parent, Cell exit) {
        LinkedList<Cell> path = new LinkedList<>();
        Cell current = exit;
        while (current != null) {
            path.addFirst(current);
            current = parent.get(current);
        }

        return path;
    }
}