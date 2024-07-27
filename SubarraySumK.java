import java.util.HashMap;

public class SubarraySumK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);

        int count = 0, prefix = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            int del = prefix - k;
            count += mpp.getOrDefault(del, 0);

            mpp.put(prefix, mpp.getOrDefault(prefix, 0) + 1);
        }
        return count;
    }
}
