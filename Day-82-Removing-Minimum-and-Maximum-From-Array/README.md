# Day 82 - Removing Minimum and Maximum From Array

## LeetCode 2091 - Removing Minimum and Maximum From Array

### Problem
Given an array of distinct integers, remove both the minimum and maximum
elements using deletions only from the front or back.

Return the minimum number of deletions required.

### Approach
- Find the indices of the minimum and maximum elements.
- Consider three possible strategies:
  1. Remove both from the front.
  2. Remove both from the back.
  3. Remove one from the front and the other from the back.
- Return the minimum of these three possibilities.

### Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

### Key Concept
Array Traversal | Greedy | Index Analysis

### LeetCode
https://leetcode.com/problems/removing-minimum-and-maximum-from-array/
