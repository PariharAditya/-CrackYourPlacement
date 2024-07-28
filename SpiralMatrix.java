import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (left <= right && up <= down) {
            for (int i = left; i <= right; i++)
                ans.add(matrix[up][i]);
            up++;

            for (int i = up; i <= down; i++)
                ans.add(matrix[i][right]);
            right--;

            if (up <= down) {
                for (int i = right; i >= left; i--)
                    ans.add(matrix[down][i]);
            }
            down--;

            if (left <= right) {
                for (int i = down; i >= up; i--)
                    ans.add(matrix[i][left]);
            }
            left++;
        }
        return ans;
    }
}
