/**
 * Class that contains the method for maze traversal. It is solved recursively and includes a back tracker.
 * @author Dean Farwell
 */
public class MazeTraversal {

    /**
     * Maze traversal method that uses checks for an open spot in four directions. Once one is found, the method is called
     * recursively by passing the next space over that is open. A back tracker is used when there are no open spots left
     * and goes backwards until another open spot is found on a different path. This repeats until it reaches an exit.
     * @param maze Matrix of characters that contains # for walls and . for open spaces.
     * @param startRow Starting row position in the maze.
     * @param startColumn Starting column position in the maze.
     * @param start Tells the maze if it is on the first call, as to not set off the edge detection for the end position.
     * @return Matrix of characters in which # are walls, . are open spaces not traveled, o are paths that lead to dead ends,
     * and x which represent the solved path.
     */
    public static char[][] mazeTraversal(char[][] maze, int startRow, int startColumn, int start) {
        maze[startRow][startColumn] = 'x'; // set current location as visited

        for (int x = 0; x < maze.length; x++) { // prints current maze
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
            } else if (maze[startRow][startColumn + 1] == 'x') { // down, backtrack, replaces x's with o's to represent failed paths
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn + 1, 0);
            } else if (maze[startRow][startColumn - 1] == 'x') { // up, backtrack
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow, startColumn - 1, 0);
            } else if (maze[startRow + 1][startColumn] == 'x') { // right, backtrack
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow + 1, startColumn, 0);
            } else if (maze[startRow - 1][startColumn] == 'x') { // left, backtrack
                maze[startRow][startColumn] = 'o';
                maze = mazeTraversal(maze, startRow - 1, startColumn, 0);
            }
        }
        return maze;
    }
}