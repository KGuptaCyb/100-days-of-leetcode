# LeetCode 3903 - Smallest Stable Index I

## 🧩 Problem

Given an integer array `nums` and an integer `k`, the instability score of an index `i` is:

`max(nums[0..i]) - min(nums[i..n-1])`

An index is stable if its instability score is less than or equal to `k`.

Return the smallest stable index. If no stable index exists, return `-1`.

---

## 💡 Approach

We need two values for every index:

1. Maximum value from the beginning up to the current index.
2. Minimum value from the current index to the end.

To efficiently calculate the suffix minimum, we create a `suffixMin` array.

Then we scan from left to right while maintaining `prefixMax`.

For each index:

```text
instability = prefixMax - suffixMin[i]
