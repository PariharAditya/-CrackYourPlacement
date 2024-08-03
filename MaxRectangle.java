import java.util.Stack;

public class MaxRectangle {

    public int maxArea(int[][] grid, int n, int m) {
        if (n == 0 || m == 0)
            return 0;
        int maxArea = 0;
        int[] heights = new int[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, maxHistogramArea(heights));
        }

        return maxArea;
    }

    private int maxHistogramArea(int[] heights) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                stack.push(i++);
            } else {
                int h = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * width);
            }
        }

        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            maxArea = Math.max(maxArea, h * width);
        }

        return maxArea;
    }

}