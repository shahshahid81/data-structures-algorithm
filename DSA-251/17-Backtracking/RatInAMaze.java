import java.util.ArrayList;

public class RatInAMaze {

  public static ArrayList<ArrayList<Integer>> ratInAMaze(int[][] maze, int n) {
    ArrayList<ArrayList<Integer>> result = new ArrayList<>();

    ArrayList<Integer> path = new ArrayList<>(n * n);
    for (int i = 0; i < n * n; i++) {
      path.add(0);
    }

    boolean[][] visited = new boolean[n][n];

    ratInAMaze(maze, n, result, path, visited, 0, 0);

    return result;
  }

  private static void ratInAMaze(
    int[][] maze,
    int n,
    ArrayList<ArrayList<Integer>> result,
    ArrayList<Integer> path,
    boolean[][] visited,
    int i,
    int j
  ) {
    if (i == n - 1 && j == n - 1) {
      if (maze[i][j] == 1) {
        setPath(path, i, j, n, 1);
        result.add(new ArrayList<>(path));
        setPath(path, i, j, n, 0);
      }
      return;
    }

    visited[i][j] = true;

    if (isValid(i - 1, n) && !visited[i - 1][j] && maze[i - 1][j] == 1) {
      setPath(path, i, j, n, 1);
      ratInAMaze(maze, n, result, path, visited, i - 1, j);
      setPath(path, i, j, n, 0);
    }

    if (isValid(i + 1, n) && !visited[i + 1][j] && maze[i + 1][j] == 1) {
      setPath(path, i, j, n, 1);
      ratInAMaze(maze, n, result, path, visited, i + 1, j);
      setPath(path, i, j, n, 0);
    }

    if (isValid(j - 1, n) && !visited[i][j - 1] && maze[i][j - 1] == 1) {
      setPath(path, i, j, n, 1);
      ratInAMaze(maze, n, result, path, visited, i, j - 1);
      setPath(path, i, j, n, 0);
    }

    if (isValid(j + 1, n) && !visited[i][j + 1] && maze[i][j + 1] == 1) {
      setPath(path, i, j, n, 1);
      ratInAMaze(maze, n, result, path, visited, i, j + 1);
      setPath(path, i, j, n, 0);
    }

    visited[i][j] = false;
  }

  private static void setPath(
    ArrayList<Integer> path,
    int i,
    int j,
    int n,
    int value
  ) {
    path.set((i * n) + (j % n), value);
  }

  private static boolean isValid(int index, int n) {
    return index >= 0 && index < n;
  }
}
