# Day 41 - Find First and Last Position of Element in Sorted Array

## 📝 Problem Statement

Given a sorted array of integers, find the first and last occurrence of a target element.

If the target does not exist, return `[-1, -1]`.

The solution must run in **O(log n)** time.

---

## 💡 Approach

Instead of scanning the array, use Binary Search twice:

1. First Binary Search finds the leftmost occurrence.
2. Second Binary Search finds the rightmost occurrence.

Both searches take logarithmic time.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search
- Lower Bound
- Upper Bound
- Searching Boundaries

---

## 🎯 Interview Pattern

- Binary Search
- Sorted Arrays

---

## 🚀 Key Takeaway

Binary Search can be adapted not only to find an element but also to locate its first and last occurrence efficiently by adjusting the search boundaries after finding the target.

---

**Language:** Java

**LeetCode:** #34 - Find First and Last Position of Element in Sorted Array
