import java.util.Arrays;

public class MColoring {

  public static String graphColoring(int[][] mat, int m) {
    int n = mat.length;
    int[] colorMatrix = new int[n];
    Arrays.fill(colorMatrix, -1);

    return graphColoring(mat, m, colorMatrix, 0) ? "YES" : "NO";
  }

  private static boolean graphColoring(
    int[][] mat,
    int m,
    int[] colorMatrix,
    int i
  ) {
    int n = mat.length;

    if (i >= n) {
      return true;
    }

    for (int color = 0; color < m; color++) {
      boolean isColorAssigned = false;
      for (int j = 0; j < n; j++) {
        if (mat[i][j] == 0) {
          continue;
        }

        if (colorMatrix[j] == color) {
          isColorAssigned = true;
          break;
        }
      }

      if (isColorAssigned) {
        continue;
      } else {
        colorMatrix[i] = color;
        boolean canColor = graphColoring(mat, m, colorMatrix, i + 1);
        if (!canColor) {
          colorMatrix[i] = -1;
          continue;
        } else {
          return true;
        }
      }
    }

    return false;
  }
}
