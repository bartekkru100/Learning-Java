import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class App {

    // 0 - wall
    // 1 - path
    // 2 - goal

    public static void main(String[] args) throws Exception {
        ArrayList<Maze> mazes = new ArrayList<Maze>();
        Maze m1 = new Maze();
        mazes.add(m1);

        for (Maze maze : mazes) {

            if (solveMaze(maze)) {
                System.out.println("You won");
            } else {
                System.out.println("OOF");

            }
        }
    }

    private static boolean solveMaze(Maze maze) {
        System.out.println("Starting new maze.");
        maze.path.push(maze.start);

        while (true) {
            // down
            int x = maze.path.peek().x;
            int y = maze.path.peek().y;
            maze.maze[y][x] = 0;
            if (maze.isValid(y + 1, x)) {
                if (maze.maze[y + 1][x] == 2) {
                    System.out.println("Moved down");
                    return true;
                } else if (maze.maze[y + 1][x] == 1) {
                    maze.path.push(new Pos(y + 1, x));
                    System.out.println("Moved down");
                    continue;
                }
            }
            // left
            if (maze.isValid(y, x - 1)) {
                if (maze.maze[y][x - 1] == 2) {
                    System.out.println("Moved left");
                    return true;
                } else if (maze.maze[y][x - 1] == 1) {
                    maze.path.push(new Pos(y, x - 1));
                    System.out.println("Moved left");
                    continue;
                }
            }
            // up
            if (maze.isValid(y - 1, x)) {
                if (maze.maze[y - 1][x] == 2) {
                    System.out.println("Moved up");
                    return true;
                } else if (maze.maze[y - 1][x] == 1) {
                    maze.path.push(new Pos(y - 1, x));
                    System.out.println("Moved up");
                    continue;
                }
            }
            // right
            if (maze.isValid(y, x + 1)) {
                if (maze.maze[y][x + 1] == 2) {
                    System.out.println("Moved right");
                    return true;
                } else if (maze.maze[y][x + 1] == 1) {
                    maze.path.push(new Pos(y, x + 1));
                    System.out.println("Moved right");
                    continue;
                }
            }

            System.out.println("Dead End");
            maze.path.pop();
            if (maze.path.size() <= 0) {
                System.out.println("No path.");
                return false;
            }
        }
    }
}
