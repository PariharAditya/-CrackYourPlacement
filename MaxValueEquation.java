import java.util.ArrayDeque;
import java.util.Deque;

public class MaxValueEquation {
    public int findMaxValueOfEquation(int[][] p, int k) {
        Deque<Integer> d = new ArrayDeque<>();
        int res = Integer.MIN_VALUE;
        for (int j = 0; j < p.length; ++j) {
            while (!d.isEmpty() && p[j][0] - p[d.peek()][0] > k)
                d.poll();
            if (!d.isEmpty())
                res = Math.max(res, p[d.peek()][1] - p[d.peek()][0] + p[j][1] + p[j][0]);
            while (!d.isEmpty() && p[d.peekLast()][1] - p[d.peekLast()][0] < p[j][1] - p[j][0])
                d.pollLast();
            d.addLast(j);
        }
        return res;
    }
}
