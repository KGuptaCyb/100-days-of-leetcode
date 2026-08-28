# Day 80 - Lexicographically Smallest Palindromic Permutation Greater Than Target

## 🧩 Problem

Given two strings `s` and `target`, find the lexicographically smallest string that:

- Is a permutation of `s`
- Is a palindrome
- Is strictly greater than `target`

Return an empty string if no valid palindrome exists.

## 💡 Approach

The key observation is that a palindrome is completely determined by its left half and middle character.

### Steps

1. Count the frequency of each character.
2. Check whether a palindromic permutation is possible.
3. Build the left half using half of each character's frequency.
4. Try matching the first half of `target`.
5. If the resulting palindrome is greater than `target`, return it.
6. Otherwise, backtrack from right to left.
7. Choose the smallest available character greater than the current target character.
8. Fill the remaining positions in ascending order.
9. Mirror the left half to form the final palindrome.

## 🧠 Concepts Learned

- Character Frequency
- Palindrome Construction
- Greedy Algorithm
- Backtracking
- Lexicographical Ordering
- String Manipulation

## ⏱️ Complexity

- Time Complexity: `O(26 × n)`
- Space Complexity: `O(n)`

## 💻 Language

Java

## 🔗 LeetCode

https://leetcode.com/problems/lexicographically-smallest-palindromic-permutation-greater-than-target/
