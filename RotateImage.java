public class RotateImage {
    public void rotate(int[][] matrix) {
        // transpose
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                matrix[row][col] ^= matrix[col][row];
                matrix[col][row] ^= matrix[row][col];
                matrix[row][col] ^= matrix[col][row];
            }
        }
        // flip
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap matrix[i][j] with matrix[i][n-j-1]
                matrix[i][j] ^= matrix[i][n - j - 1];
                matrix[i][n - j - 1] ^= matrix[i][j];
                matrix[i][j] ^= matrix[i][n - j - 1];
            }
        }
    }
}
