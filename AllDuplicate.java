import java.util.ArrayList;
import java.util.List;

public class AllDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        // mark -ve if it's already -ve add to list
        // make easy to understand we're doing this nums[x -1] due to
        // [1, n] or 1- based indexing.
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int x = Math.abs(nums[i]);

            if (nums[x - 1] < 0) {
                ans.add(x);
            } else {
                nums[x - 1] = -nums[x - 1];
            }
        }
        return ans;
    }
}
