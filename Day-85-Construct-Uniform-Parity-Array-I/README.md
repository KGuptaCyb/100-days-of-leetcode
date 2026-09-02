# Day 85 - Construct Uniform Parity Array I

## LeetCode 3875

### Problem
Determine whether it is possible to construct an array where all elements have the same parity (all odd or all even).

### Approach
The solution is based on parity properties:

- Even - Odd = Odd
- Odd - Even = Odd
- Even - Even = Even
- Odd - Odd = Even

If all elements already have the same parity, we can keep them unchanged.

If both odd and even elements exist, subtracting an element with opposite parity can make the resulting value odd.

Therefore, the construction is always possible.

### Key Concepts
- Parity
- Mathematical Observation
- Array Traversal

### Complexity
- Time: O(n)
- Space: O(1)

### Language
Java

### LeetCode
https://leetcode.com/problems/construct-uniform-parity-array-i/
