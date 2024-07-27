public class ContainerWithWater {
    // formula(Area) = H * B ==> ans
    // B = right - left
    // move pointer which is smaller
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);

            maxWater = Math.max(maxWater, h * (right - left));

            while (left < right && height[left] <= h) {
                left++;
            }
            while (left < right && height[right] <= h) {
                right--;
            }
        }
        return maxWater;
    }
}
