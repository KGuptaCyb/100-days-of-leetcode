# Day 64 - Permutation in String

## LeetCode 567

Given two strings `s1` and `s2`, determine whether `s2` contains a permutation of `s1`.

## Approach

I used a Fixed-Size Sliding Window with a frequency array.

- Count the frequency of characters in `s1`.
- Maintain a window of size `s1.length()` in `s2`.
- Update the character frequencies while moving the window.
- If all frequencies become zero, the current window is a permutation of `s1`.

## Complexity

- Time Complexity: O(n)
- Space Complexity: O(1)

## Key Concepts

- Sliding Window
- String Manipulation
- Frequency Array
- Hashing / Counting
