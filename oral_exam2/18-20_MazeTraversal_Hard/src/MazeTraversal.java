public class MazeTraversal {
    public static char[][] mazeTraversal(char[][] maze, int startRow, int startColumn, int start) {
        maze[startRow][startColumn] = 'x';

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y] + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        if ((startRow != 0 && startRow != 11 && startColumn != 0 && startColumn != 11) || start == 1) { // if it isn't first, detects the edge which should be the end
            if (startColumn != 11 && maze[startRow][startColumn + 1] == '.') { // down
                maze = mazeTraversal(maze, startRow, startColumn + 1, 0);
            } else if (startColumn != 0 && maze[startRow][startColumn - 1] == '.') { // up
                maze = mazeTraversal(maze, startRow, startColumn - 1, 0);
            } else if (startRow != 11 && maze[startRow + 1][startColumn] == '.') { // right
                maze = mazeTraversal(maze, startRow + 1, startColumn, 0);
            } else if (startRow != 0 && maze[startRow - 1][startColumn] == '.') { // left
                maze = mazeTraversal(maze, startRow - 1, startColumn, 0);
            } else if (maze[startRow][startColumn + 1] == 'x') { // down
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn + 1, 0);
            } else if (maze[startRow][startColumn - 1] == 'x') { // up
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn - 1, 0);
            } else if (maze[startRow + 1][startColumn] == 'x') { // right
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow + 1, startColumn, 0);
            } else if (maze[startRow - 1][startColumn] == 'x') { // left
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow - 1, startColumn, 0);
            }
        }
        return maze;
    }
}