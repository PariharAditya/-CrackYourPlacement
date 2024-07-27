public class MaxPointObtained {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;
        
        // Calculate the total sum of the first k cards
        for (int i = 0; i < k; i++) {
            totalSum += cardPoints[i];
        }
        
        int maxSum = totalSum;
        
        // Use a sliding window to find the maximum sum by including cards from the end
        for (int i = 0; i < k; i++) {
            totalSum = totalSum - cardPoints[k - 1 - i] + cardPoints[n - 1 - i];
            maxSum = Math.max(maxSum, totalSum);
        }
        
        return maxSum;
    }
}
