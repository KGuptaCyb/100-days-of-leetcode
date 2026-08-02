# Day 54 - Daily Temperatures

## 📝 Problem Statement

Given an array of daily temperatures, return an array where each element represents the number of days until a warmer temperature. If there is no future warmer day, return 0 for that position.

---

## 💡 Approach

This problem is solved using a **Monotonic Decreasing Stack**.

- Store indices in the stack.
- Traverse the array once.
- Whenever a warmer temperature is found, pop indices from the stack and calculate the waiting days.
- Push the current index after processing.

This ensures each index is pushed and popped at most once.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

## 📚 Concepts Learned

- Monotonic Stack
- Stack
- Array Traversal
- Next Greater Element Pattern
- Efficient Index Tracking

---

## 🎯 Key Takeaway

The Monotonic Stack efficiently solves "next greater element" type problems in linear time by maintaining indices in decreasing order.

**Language:** Java

**LeetCode:** #739 - Daily Temperatures
