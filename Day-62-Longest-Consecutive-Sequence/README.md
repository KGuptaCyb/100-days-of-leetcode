# Day 62 - Longest Consecutive Sequence

## 📝 Problem Statement

Given an unsorted array of integers `nums`, return the length of the longest consecutive elements sequence.

The solution must run in `O(n)` time.

---

## 💡 Approach

I used a `HashSet` to achieve an average `O(1)` lookup time.

### Steps

1. Store all elements of the array in a HashSet.
2. Traverse the elements in the set.
3. For every number, check whether `num - 1` exists.
4. If it doesn't exist, the current number is the beginning of a consecutive sequence.
5. Continue checking `num + 1`, `num + 2`, and so on.
6. Keep track of the longest sequence found.

---
