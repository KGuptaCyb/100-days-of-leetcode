class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }

        int dp = sum;
        int prefix = 0;
        int[] prefixSum = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }

        for (int i = n - 1; i >= 2; i--) {
            dp = Math.max(dp, prefixSum[i] - dp);
        }

        return dp;
    }
}
