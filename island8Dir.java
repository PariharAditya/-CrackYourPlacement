public class island8Dir {
    public int numIslands(char[][] grid) {
        // Code here
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    DFS(i, j, grid);
                    count++;
                }
            }
        }
        return count;
    }

    void DFS(int i, int j, char[][] matrix) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] != '1')
            return;

        // marking the cell visited
        // help this to prevent revisiting
        matrix[i][j] = '#';

        DFS(i + 1, j, matrix);
        DFS(i - 1, j, matrix);
        DFS(i, j + 1, matrix);
        DFS(i, j - 1, matrix);

        // diagonally
        DFS(i + 1, j + 1, matrix);
        DFS(i - 1, j - 1, matrix);
        DFS(i + 1, j - 1, matrix);
        DFS(i - 1, j + 1, matrix);
    }
}
