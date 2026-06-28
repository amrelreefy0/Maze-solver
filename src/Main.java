import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ===========================
        // Test Case 1 : Valid Maze
        // ===========================
        System.out.println("===== TEST CASE 1 : Valid Maze =====");

        char[][] maze1 = {
                {'S', '0', '1', '0', '0'},
                {'0', '0', '1', '0', '1'},
                {'1', '0', '0', '0', '1'},
                {'1', '1', '1', '0', '0'},
                {'0', '0', '0', '0', 'E'}
        };

        runMaze(maze1);


        // ===========================
        // Test Case 2 : No Path
        // ===========================
        System.out.println("\n===== TEST CASE 2 : No Path =====");

        char[][] maze2 = {
                {'S', '1', '0'},
                {'1', '1', '0'},
                {'0', '0', 'E'}
        };

        runMaze(maze2);


        // ===========================
        // Test Case 3 : Missing Start
        // ===========================
        System.out.println("\n===== TEST CASE 3 : Missing Start =====");

        char[][] maze3 = {
                {'0', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', 'E'}
        };

        runMaze(maze3);


        // ===========================
        // Test Case 4 : Missing Exit
        // ===========================
        System.out.println("\n===== TEST CASE 4 : Missing Exit =====");

        char[][] maze4 = {
                {'S', '0', '0'},
                {'0', '1', '0'},
                {'0', '0', '0'}
        };

        runMaze(maze4);


        // ===========================
        // Test Case 5 : Simple Path
        // ===========================
        System.out.println("\n===== TEST CASE 5 : Simple Path =====");

        char[][] maze5 = {
                {'S', '0', '0', '0', 'E'}
        };

        runMaze(maze5);
    }

    private static void runMaze(char[][] grid) {
        try {
            Maze maze = new Maze(grid);

            System.out.println("\nOriginal Maze:");
            maze.print();

            MazeSolver solver = new MazeSolver(maze);
            List<Cell> path = solver.solve();

            if (path == null) {
                System.out.println("\nNo valid path exists between S and E.");
            } else {
                maze.markPath(path);

                System.out.println("\nSolved Maze:");
                maze.print();

                System.out.println("\nPath found in "
                        + (path.size() - 1)
                        + " steps.");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
