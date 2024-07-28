import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(ans, new ArrayList<>(), nums, new boolean[nums.length]);

        return ans;
    }

    void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, boolean[] checked) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (checked[i] || i > 0 && nums[i] == nums[i - 1] && !checked[i - 1])
                    continue;
                checked[i] = true;
                temp.add(nums[i]);
                backtrack(list, temp, nums, checked);
                checked[i] = false;
                temp.remove(temp.size() - 1);
            }
        }

    }
}
