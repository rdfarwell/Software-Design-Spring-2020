public class MazeTraversalMain {
    public static void main(String[] args) {
        char[][] maze = new char[12][12];
        int startRow = 1, startColumn = 0;
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

        maze = MazeTraversal.mazeTraversal(maze, startRow, startColumn);

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y]  + "  ");
            }
            System.out.print("\n");
        }


    }
}
