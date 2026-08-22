# Day 74 – Unique Paths

## LeetCode 62 – Unique Paths

### Problem
Given an `m x n` grid, find the number of unique paths from the top-left corner to the bottom-right corner.

You can only move:
- Right
- Down

### Approach
Used **Dynamic Programming**.

`dp[i][j]` represents the number of unique paths to reach cell `(i, j)`.

For the first row and first column, there is only one possible path.

For every other cell:

`dp[i][j] = dp[i-1][j] + dp[i][j-1]`

### Complexity
- Time: O(m × n)
- Space: O(m × n)

### Key Concepts
- Dynamic Programming
- 2D Grid
- State Transition
- Base Cases
- Path Counting

### Language
Java
