import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n417_Pacific_Atlantic_Water_Flow {

    public List<List<Integer>> n417_Pacific_Atlantic_Water_Flow(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        final int m = matrix.length;
        if(m == 0) {
            return result;
        }
        final int n = matrix[0].length;

        boolean[][] P = new boolean[m][n];
        boolean[][] A = new boolean[m][n];

        for(int x = 0; x < m; ++x) {
            dfs(matrix, x, 0, matrix[x][0], P); //top
            dfs(matrix, x, n - 1, matrix[x][n - 1], A); //bottom
        }

        for(int y = 0; y < n; ++y) {
            dfs(matrix, 0, y, matrix[0][y], P); //left
            dfs(matrix, m - 1, y, matrix[m - 1][y], A); //right
        }

        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(P[i][j] && A[i][j]) {
                    result.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] m, int x, int y, int h, boolean[][] visited) {
        if(x < 0 || x >= m.length || y < 0 || y >= m[0].length || visited[x][y] || m[x][y] < h) {
            return;
        }
        visited[x][y] = true;
        dfs(m, x + 1, y, m[x][y], visited);
        dfs(m, x - 1, y, m[x][y], visited);
        dfs(m, x, y + 1, m[x][y], visited);
        dfs(m, x, y - 1, m[x][y], visited);
    }
}
