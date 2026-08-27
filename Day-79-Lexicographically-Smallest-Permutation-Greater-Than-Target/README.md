# Day 79 - Lexicographically Smallest Permutation Greater Than Target

## 🧩 LeetCode 3720

Given two strings `s` and `target`, find the lexicographically smallest permutation of `s` that is strictly greater than `target`.

If no such permutation exists, return an empty string.

### 💡 Approach

Used a **Greedy + Frequency Counting** approach.

- Count the frequency of each character in `s`.
- Try to match the characters of `target` from left to right.
- If the current character is available, keep the prefix equal.
- When the prefix can no longer be continued, find a position where we can place the smallest character greater than the target character.
- After making the string greater, append all remaining characters in sorted order.
- If the complete target can be formed, backtrack from the right to find the smallest possible increase.

### 🔑 Key Concepts

- Greedy Algorithm
- Frequency Array
- Lexicographical Ordering
- String Permutations
- Backtracking
- Character Counting

### ⏱️ Complexity

- Time Complexity: `O(26 × n)` ≈ `O(n)`
- Space Complexity: `O(26)`

### 🛠️ Language

Java

### 🔗 LeetCode

https://leetcode.com/problems/lexicographically-smallest-permutation-greater-than-target/
