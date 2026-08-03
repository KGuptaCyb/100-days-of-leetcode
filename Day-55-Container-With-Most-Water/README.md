# Day 55 - Container With Most Water

## 📝 Problem Statement

Given an array `height`, find two lines that together with the x-axis form a container capable of holding the maximum amount of water.

---

## 💡 Approach

This problem is solved using the **Two Pointer** technique.

- Start with one pointer at each end of the array.
- Calculate the area formed by the two lines.
- Update the maximum area found.
- Move the pointer pointing to the shorter line, as it is the limiting factor.

This approach guarantees the optimal solution in linear time.

---


## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Two Pointers
- Greedy Strategy
- Array Traversal
- Optimization

---

## 🎯 Key Takeaway

The Two Pointer technique efficiently solves this problem by eliminating unnecessary comparisons and reducing the time complexity from `O(n²)` to `O(n)`.

**Language:** Java

**LeetCode:** #11 - Container With Most Water
