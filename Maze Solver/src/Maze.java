import java.util.LinkedList;

public class Maze {
    public int[][] maze;
    public LinkedList<Pos> path;
    public Pos start;
    public Maze()
    {
        path = new LinkedList<Pos>();

    }
    public boolean isValid(int y, int x) {
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;
    }
}
