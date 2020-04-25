public class MazeTraversal {

//    char[][]maze;
//
//    MazeTraversal(char[][] maze, int startRow, int startColumn) {
//
//    }

    public static char[][] mazeTraversal(char[][] maze, int startRow, int startColumn) {
        maze[startRow][startColumn] = 'x';

        for (int x = 0; x < maze.length; x++) {
            for (int y = 0; y < maze[x].length; y++) {
                System.out.print(maze[x][y]  + "  ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        try {
            if (maze[startRow][startColumn + 1] == '.') { // down
                maze = mazeTraversal(maze, startRow, startColumn + 1);
            } else if (maze[startRow][startColumn - 1] == '.') { // up
                maze = mazeTraversal(maze, startRow, startColumn - 1);
            } else if (maze[startRow + 1][startColumn] == '.') { // right
                maze = mazeTraversal(maze, startRow + 1, startColumn);
            } else if (maze[startRow - 1][startColumn] == '.') { // left
                maze = mazeTraversal(maze, startRow - 1, startColumn);
            } else if (maze[startRow][startColumn + 1] == 'x' && maze[startRow][startColumn - 1] != '.'
                    && maze[startRow + 1][startColumn] != '.' && maze[startRow - 1][startColumn] != '.') { // down
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn + 1);
            } else if (maze[startRow][startColumn + 1] != '.' && maze[startRow][startColumn - 1] == 'x'
                    && maze[startRow + 1][startColumn] != '.' && maze[startRow - 1][startColumn] != '.') { // up
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn - 1);
            } else if (maze[startRow][startColumn + 1] != '.' && maze[startRow][startColumn - 1] != '.'
                    && maze[startRow + 1][startColumn] == 'x' && maze[startRow - 1][startColumn] != '.') { // right
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow + 1, startColumn);
            } else if (maze[startRow][startColumn + 1] != '.' && maze[startRow][startColumn - 1] != '.'
                    && maze[startRow + 1][startColumn] != '.' && maze[startRow - 1][startColumn] == 'x') { // left
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow - 1, startColumn);
            }
        }
        catch (ArrayIndexOutOfBoundsException outOfMaze) {

        }

        return maze;
    }
}
