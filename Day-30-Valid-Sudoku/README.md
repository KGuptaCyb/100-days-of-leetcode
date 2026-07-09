# Day 30 - Valid Sudoku

## Problem Statement

Determine if a **9 × 9 Sudoku** board is valid. Only the filled cells need to be validated according to the following rules:

- Each row must contain the digits `1-9` without repetition.
- Each column must contain the digits `1-9` without repetition.
- Each 3 × 3 sub-box must contain the digits `1-9` without repetition.

> Note: A Sudoku board could be valid but not necessarily solvable.

---

##  Approach

Instead of checking rows, columns, and boxes separately multiple times, I used a **HashSet** to track previously seen numbers.

For every filled cell:

- Check if the number already exists in the current row.
- Check if the number already exists in the current column.
- Check if the number already exists in the corresponding 3×3 box.
- If any duplicate is found, return `false`.
- Otherwise, store all three identifiers in the HashSet.

The box is identified using:

```java
(row / 3) + "-" + (col / 3)
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(81)` ≈ `O(1)`

- The board size is fixed (9 × 9).

**Space Complexity:** `O(81)` ≈ `O(1)`

- HashSet stores at most one entry for each row, column, and box.

---

## 🧠 Concepts Learned

- Matrix Traversal
- HashSet
- Hashing
- Coordinate Mapping
- Duplicate Detection
- 2D Arrays

---

## 🎯 Interview Pattern

- Matrix
- Hashing
- Arrays

---

## 🚀 Key Takeaway

Instead of repeatedly checking rows, columns, and sub-boxes, using a HashSet allows duplicate detection in constant time, making the solution simple, clean, and efficient.

---

**Language:** Java

**LeetCode:** #36 - Valid Sudoku
