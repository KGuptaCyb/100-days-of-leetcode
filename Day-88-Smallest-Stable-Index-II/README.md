# LeetCode 3904 - Smallest Stable Index II

## Problem

Given an integer array `nums` and an integer `k`, the instability score of an index `i` is:

`max(nums[0..i]) - min(nums[i..n-1])`

An index is stable if its instability score is less than or equal to `k`.

Return the smallest stable index. If no stable index exists, return `-1`.

---

## Approach

For every index, we need:

1. The maximum value from index `0` to `i`.
2. The minimum value from index `i` to `n - 1`.

Instead of calculating these values repeatedly, we use a prefix maximum and a suffix minimum array.

### Step 1: Build Suffix Minimum

Create `suffixMin` where:

`suffixMin[i]` stores the minimum value from `i` to the end of the array.

We calculate this from right to left.

### Step 2: Maintain Prefix Maximum

Traverse the array from left to right.

For every index:

`prefixMax = maximum(nums[0..i])`

Then calculate:

`instability = prefixMax - suffixMin[i]`

If:

`instability <= k`

then the current index is stable, so we immediately return it.

If no index satisfies the condition, return `-1`.

---

## Key Insight

The main optimization is avoiding repeated range maximum and minimum calculations.

By combining:

- Prefix Maximum
- Suffix Minimum

we can solve the problem in linear time.

---

## Java Solution

```java
class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int[] suffixMin = new int[n];

        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);

            long instability = (long) prefixMax - suffixMin[i];

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }
}
