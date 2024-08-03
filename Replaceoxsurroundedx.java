public class Replaceoxsurroundedx {
    static char[][] fill(int N, int M, char mat[][]) {
        // Traverse the boundary and mark 'O's connected to boundary 'O's
        for (int i = 0; i < N; i++) {
            if (mat[i][0] == 'O') {
                DFS(i, 0, mat);
            }
            if (mat[i][M - 1] == 'O') {
                DFS(i, M - 1, mat);
            }
        }

        for (int j = 0; j < M; j++) {
            if (mat[0][j] == 'O') {
                DFS(0, j, mat);
            }
            if (mat[N - 1][j] == 'O') {
                DFS(N - 1, j, mat);
            }
        }

        // Replace all 'O' with 'X' and revert '#' back to 'O'
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 'O') {
                    mat[i][j] = 'X';
                } else if (mat[i][j] == '#') {
                    mat[i][j] = 'O';
                }
            }
        }
        return mat;
    }

    private static void DFS(int i, int j, char[][] mat) {
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != 'O') {
            return;
        }
        // Mark the cell as visited
        mat[i][j] = '#';
        // Explore all four directions
        DFS(i + 1, j, mat);
        DFS(i - 1, j, mat);
        DFS(i, j + 1, mat);
        DFS(i, j - 1, mat);
    }
}
