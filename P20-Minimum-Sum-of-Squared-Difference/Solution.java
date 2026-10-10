class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;

        int[] diff = new int[n];
        int maxDiff = 0;
        long totalDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diff[i]);
            totalDiff += diff[i];
        }
        if (k >= totalDiff) {
            return 0;
        }
        int left = 0;
        int right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;
            long operations = 0;

            for (int d : diff) {
                if (d > mid) {
                    operations += d - mid;
                }
            }

            if (operations <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int level = left;
        long operations = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] > level) {
                operations += diff[i] - level;
                diff[i] = level;
            }
        }
        long remaining = k - operations;

        if (level > 0) {
            for (int i = 0; i < n && remaining > 0; i++) {
                if (diff[i] == level) {
                    diff[i]--;
                    remaining--;
                }
            }
        }
        long answer = 0;

        for (int d : diff) {
            answer += (long) d * d;
        }

        return answer;
    }
}
