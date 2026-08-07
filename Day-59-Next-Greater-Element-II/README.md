# Day 59 - Next Greater Element II

## 📝 Problem Statement

Given a circular integer array `nums`, return the next greater element for every element in the array.

The next greater element of a number is the first greater number to its right while traversing the array circularly. If no such element exists, return `-1`.

---

## 💡 Approach

This problem is solved using a **Monotonic Decreasing Stack**.

### Algorithm

1. Initialize the answer array with `-1`.
2. Traverse the array twice from right to left to simulate circular traversal.
3. Maintain a stack containing elements greater than the current element.
4. Remove all elements from the stack that are smaller than or equal to the current element.
5. During the second pass (`i < n`), assign the top of the stack as the next greater element.
6. Push the current element onto the stack.

This efficiently finds the next greater element for every position.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

## 📚 Concepts Learned

- Monotonic Decreasing Stack
- Circular Array
- Stack
- Reverse Traversal
- Efficient Array Processing

---

## 🎯 Key Takeaway

A monotonic stack helps efficiently determine the next greater element. Traversing the array twice allows us to handle the circular nature of the problem without increasing the time complexity beyond `O(n)`.

---

### 🚀 Problem Information

- **Platform:** LeetCode
- **Problem:** 503. Next Greater Element II
- **Difficulty:** Medium
- **Language:** Java
