/**
 * Main class of MazeTraversal_Hard that sets up the maze and handles the cleaning of the final output of the maze to only show the solved path.
 * @author Dean Farwell
 */
public class MazeTraversalMain {

    /**
     * Main method of MazeTraversal_Hard that initializes the maze and cleans the final output
     * @param args String array of arguments as required by Java
     */
    public static void main(String[] args) {
        char[][] maze = new char[12][12];
        int startRow = 10, startColumn = 11;
        maze[0] = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};
        maze[1] = new char[]{'.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'};
        maze[2] = new char[]{'#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#'};
        maze[3] = new char[]{'#', '.', '#', '#', '#', '#', '#', '#', '.', '#', '.', '#'};
        maze[4] = new char[]{'#', '.', '.', '.', '#', '#', '#', '#', '.', '#', '.', '#'};
        maze[5] = new char[]{'#', '.', '#', '.', '#', '.', '.', '#', '.', '#', '#', '#'};
        maze[6] = new char[]{'#', '.', '#', '.', '#', '#', '.', '#', '.', '.', '#', '#'};
        maze[7] = new char[]{'#', '.', '#', '.', '#', '#', '.', '#', '#', '.', '#', '#'};
        maze[8] = new char[]{'#', '#', '#', '.', '.', '.', '.', '#', '#', '.', '.', '#'};
        maze[9] = new char[]{'#', '.', '.', '.', '#', '#', '#', '#', '#', '#', '#', '#'};
        maze[10] = new char[]{'#', '.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '.'};
        maze[11] = new char[]{'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

        maze = MazeTraversal.mazeTraversal(maze, startRow, startColumn, 1);

        // cleans the output to only show the solved path, not the attempted paths
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                if (maze[x][y] == 'o') {
                    maze[x][y] = '.';
                }
            }
        }

        // outputs final cleaned maze
        System.out.println("Solved Maze:");
        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y]  + "  ");
            }
            System.out.print("\n");
        }
    }
}