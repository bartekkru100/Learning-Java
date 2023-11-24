import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Maze {
    public int[][] maze;
    public LinkedList<Pos> path;
    public Pos start;

    public Maze() throws FileNotFoundException {
        path = new LinkedList<Pos>();

        Scanner in = new Scanner(new File("maze.txt"));
        ArrayList<ArrayList<Integer>> tempMaze = new ArrayList<ArrayList<Integer>>();
        while (in.hasNextLine()) {
            if (in.nextLine().equals("maze:")) {
                for (int i = 0; in.hasNextInt(); i++) {
                    tempMaze.add(new ArrayList<Integer>());
                    String[] row = in.nextLine().split(" ");
                    for (String element : row) {
                        tempMaze.get(i).add(Integer.parseInt(element));
                    }
                System.out.println(tempMaze.get(i).toString());
                }
            }
            System.out.println(in.nextLine());
            start = new Pos(in.nextInt(), in.nextInt());
            maze = new int[tempMaze.size()][];
            for (int i = 0; i < tempMaze.size(); i++){
                maze[i] = new int[tempMaze.get(i).size()];
                for (int j = 0; j < tempMaze.get(i).size(); j++)
                {
                    maze[i][j] = tempMaze.get(i).get(j);
                }
            }
        }
    }

    public boolean isValid(int y, int x) {
        if (y < 0 || y >= maze.length || x < 0 || x >= maze[y].length) {
            return false;
        }
        return true;
    }
}
