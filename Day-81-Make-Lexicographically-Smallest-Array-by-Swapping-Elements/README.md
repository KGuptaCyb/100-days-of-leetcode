# Day 81 - Make Lexicographically Smallest Array by Swapping Elements

## LeetCode 948 - Medium

### Problem
Given an array `nums` and a `limit`, we can swap two elements when the absolute difference between their values is at most `limit`.

The goal is to return the lexicographically smallest array obtainable through any number of valid swaps.

### Approach
- Store each value along with its original index.
- Sort the elements by value.
- Group elements where consecutive values differ by at most `limit`.
- For every group:
  - Sort the original indices.
  - Assign the smallest values to the smallest indices.
- Construct the final lexicographically smallest array.

### Key Concept
The important observation is that valid swaps create connected groups of elements. Once elements belong to the same group, their values can be rearranged among their original positions.

### Complexity
- Time Complexity: `O(n log n)`
- Space Complexity: `O(n)`

### Language
Java

### LeetCode
[948. Make Lexicographically Smallest Array by Swapping Elements](https://leetcode.com/problems/make-lexicographically-smallest-array-by-swapping-elements/)
