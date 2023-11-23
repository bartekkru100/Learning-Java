import java.util.LinkedList;

public class App {

    static int[][] maze = {
            { 2, 0, 0, 0, 1, 1, 0, 1},
            { 1, 0, 1, 0, 1, 0, 0, 1},
            { 1, 0, 1, 0, 1, 1, 1, 1},
            { 1, 0, 1, 0, 1, 0, 1, 0},
            { 1, 0, 1, 1, 1, 0, 1, 1},
            { 1, 0, 0, 0, 1, 1, 0, 1},
            { 1, 1, 0, 1, 0, 1, 0, 1},
            { 0, 1, 1, 1, 1, 1, 1, 1},
    };
    // 0 - wall
    // 1 - path
    // 2 - goal
    static LinkedList<Pos> path = new LinkedList<Pos>();

    public static void main(String[] args) throws Exception {
        Pos p = new Pos(0, 5);
        path.push(p);

        while (true) {
            // down
            int x = path.peek().x;
            int y = path.peek().y;
            maze[y][x] = 0;
            if (isValid(y + 1, x)) {
                if (maze[y + 1][x] == 2) {
                    System.out.println("Moved down. You won!");
                    return;
                } else if (maze[y + 1][x] == 1) {
                    path.push(new Pos(y + 1, x));
                    System.out.println("Moved down");
                    continue;
                }
            }
            // left
            if (isValid(y, x - 1)) {
                if (maze[y][x - 1] == 2) {
                    System.out.println("Moved left. You won!");
                    return;
                } else if (maze[y][x - 1] == 1) {
                    path.push(new Pos(y, x - 1));
                    System.out.println("Moved left");
                    continue;
                }
            }
            // up
            if (isValid(y - 1, x)) {
                if (maze[y - 1][x] == 2) {
                    System.out.println("Moved up. You won!");
                    return;
                } else if (maze[y - 1][x] == 1) {
                    path.push(new Pos(y - 1, x));
                    System.out.println("Moved up");
                    continue;
                }
            }
            // right
            if (isValid(y, x + 1)) {
                if (maze[y][x + 1] == 2) {
                    System.out.println("Moved right. You won!");
                    return;
                } else if (maze[y][x + 1] == 1) {
                    path.push(new Pos(y, x + 1));
                    System.out.println("Moved right");
                    continue;
                }
            }
            
            System.out.println("Dead End");
            path.pop();
            if (path.size() <= 0) {
                System.out.println("No path.");
                return;
            }
        }
    }

    public static boolean isValid(int y, int x) {
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;
    }
}
