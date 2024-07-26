import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {
    
    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        // your code here
        Collections.sort(a);
        long min = Long.MAX_VALUE;

        int i = 0;
        int j = m - 1;
        while (j < n) {
            min = Math.min(min, a.get(j) - a.get(i));
            i++;
            j++;
        }
        return min;
    }
}
