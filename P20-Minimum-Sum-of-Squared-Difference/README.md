# LeetCode 2333 — Minimum Sum of Squared Difference

**Difficulty:** Medium
**Language:** Java
**Topics:** Greedy, Binary Search, Arrays

## Problem Statement

Given two integer arrays, `nums1` and `nums2`, and two integers `k1` and `k2`, minimize the sum of squared differences between corresponding array elements.

You can increase or decrease elements in `nums1` at most `k1` times and in `nums2` at most `k2` times.

The objective is to minimize:

$$
\sum_{i=0}^{n-1} (nums1[i]-nums2[i])^2
$$

## Approach: Binary Search + Greedy

Instead of reducing differences one operation at a time, we use binary search to find a suitable difference level.

### Steps

1. Calculate the absolute difference between corresponding elements.
2. If the total available operations can eliminate all differences, return `0`.
3. Use binary search to find the smallest level such that reducing all differences above that level requires no more than `k1 + k2` operations.
4. Reduce every difference above the selected level.
5. Use any remaining operations to reduce individual differences by one.
6. Calculate the sum of the squared differences and return the answer.

### Example

**Input:**

```text
nums1 = [1, 4, 10, 12]
nums2 = [5, 8, 6, 9]
k1 = 1
k2 = 1
```

Initial absolute differences:

```text
[4, 4, 4, 3]
```

There are two available operations. Reduce two of the differences by one:

```text
[3, 3, 4, 3]
```

Calculate the squared sum:

```text
3² + 3² + 4² + 3²
= 9 + 9 + 16 + 9
= 43
```

**Output:** `43`

## Complexity Analysis

* **Time Complexity:** `O(n × log D)`, where `n` is the array length and `D` is the maximum absolute difference.
* **Space Complexity:** `O(n)` for storing the absolute differences.

## Key Learning

* Greedy algorithms help minimize large differences first.
* Binary search can optimize a solution when the required number of operations changes monotonically with a chosen threshold.
* Use `long` for the operation count and squared sum to avoid integer overflow.

## LeetCode

[Minimum Sum of Squared Difference — Problem 2333](https://leetcode.com/problems/minimum-sum-of-squared-difference/)

## Hashtags

#LeetCode #Java #DSA #BinarySearch #Greedy #DrGViswanathan
