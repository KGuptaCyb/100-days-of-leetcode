# Day 39 - Search in Rotated Sorted Array

## 📝 Problem Statement

Given a rotated sorted array and a target value, return its index if found; otherwise, return `-1`.

Your solution must run in **O(log n)** time.

---

## 💡 Approach

- Use Binary Search.
- At every step, determine which half of the array is sorted.
- Check whether the target belongs to the sorted half.
- Discard the other half.
- Repeat until the target is found.

---

## 📊 Complexity

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search
- Modified Binary Search
- Rotated Sorted Array
- Decision Making

---

## 🎯 Interview Pattern

- Binary Search
- Arrays

---

**Language:** Java

**LeetCode:** #33 - Search in Rotated Sorted Array
