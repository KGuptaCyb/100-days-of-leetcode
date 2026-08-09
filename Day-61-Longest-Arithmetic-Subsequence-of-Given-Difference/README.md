# Day 61 - Longest Arithmetic Subsequence of Given Difference

## 📝 Problem Statement

Given an integer array `arr` and an integer `difference`, return the length of the longest subsequence in `arr` which is an arithmetic sequence such that the difference between adjacent elements is exactly `difference`.

A subsequence can be obtained by deleting some elements from the array without changing the order of the remaining elements.

---

## 💡 Approach

This problem can be solved efficiently using a `HashMap` and Dynamic Programming.

For every number `num`, we look for its required previous value:

previous = num - difference

If a subsequence ending with `previous` already exists, we can extend it by `num`.

Therefore:

dp[num] = dp[previous] + 1

If `previous` does not exist, the subsequence starts with the current number:

dp[num] = 1

We store the longest subsequence ending at each value in a `HashMap`.

---

## 🔑 Algorithm

1. Create a `HashMap` to store the longest subsequence ending at each number.
2. Traverse the array from left to right.
3. For every `num`, calculate:
   
   `previous = num - difference`

4. Get the length of the subsequence ending at `previous`.
5. Extend it by adding `num`.
6. Update the maximum length.
7. Return the maximum length.

---
