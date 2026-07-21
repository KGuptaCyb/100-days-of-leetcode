# Day 42 - Search a 2D Matrix

## 📝 Problem Statement

Given an `m x n` matrix where:

- Each row is sorted.
- The first element of each row is greater than the last element of the previous row.

Determine whether a target value exists in the matrix.

---

## 💡 Approach

The matrix behaves like one large sorted array.

- Perform Binary Search on indices from `0` to `m × n - 1`.
- Convert the 1D index into row and column indices using:
  - `row = mid / columns`
  - `col = mid % columns`

This avoids searching each row separately.

---

## 🧠 Dry Run

Input:

```text
matrix = [[1,3,5,7],
          [10,11,16,20],
          [23,30,34,60]]
target = 16
```

- `mid = 5`
- `row = 5 / 4 = 1`
- `col = 5 % 4 = 1`
- Value = `11`

Since `11 < 16`, move right.

Next:

- `mid = 6`
- `row = 1`
- `col = 2`
- Value = `16`

Target found ✅

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(log(m × n))`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search
- Matrix Index Mapping
- 2D Arrays
- Search Optimization

---

## 🎯 Interview Pattern

- Binary Search
- Matrix Problems

---

## 🚀 Key Takeaway

A sorted 2D matrix can be treated as a single sorted array. Mapping a 1D index to 2D coordinates enables an efficient Binary Search without traversing each row.

---

**Language:** Java

**LeetCode:** #74 - Search a 2D Matrix
