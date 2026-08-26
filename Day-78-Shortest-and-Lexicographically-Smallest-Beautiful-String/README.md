# Day 78 - Shortest and Lexicographically Smallest Beautiful String

## 🧩 LeetCode 2904

Given a binary string `s` and an integer `k`, find the shortest substring containing exactly `k` ones.

If multiple substrings have the same minimum length, return the lexicographically smallest one.

### 💡 Approach

Used the **Sliding Window** technique.

- Maintain a window using two pointers.
- Count the number of `1`s inside the current window.
- Shrink the window whenever the count exceeds `k`.
- Once the window contains exactly `k` ones, remove unnecessary leading zeros.
- Compare the resulting substring with the current best answer.

### 🔑 Key Concepts

- Sliding Window
- Two Pointers
- String Comparison
- Lexicographical Ordering
- Substring Optimization

### ⏱️ Complexity

- Time Complexity: `O(n²)` in the worst case
- Space Complexity: `O(n)`

### 🛠️ Language

Java

### 🔗 LeetCode

https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/
