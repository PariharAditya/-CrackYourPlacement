public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0)) {
                    if (search(board, 0, word, row, column))
                        return true;
                }
            }
        }
        return false;

    }

    boolean search(char[][] matrix, int index, String word, int row, int column) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= matrix.length ||
                column < 0 || column >= matrix[0].length ||
                matrix[row][column] != word.charAt(index)) {
            return false;
        }

        char temp = matrix[row][column];
        matrix[row][column] = '#';

        boolean found = search(matrix, index + 1, word, row + 1, column) ||
                search(matrix, index + 1, word, row, column + 1) ||
                search(matrix, index + 1, word, row - 1, column) ||
                search(matrix, index + 1, word, row, column - 1);

        matrix[row][column] = temp;
        return found;
    }
}
