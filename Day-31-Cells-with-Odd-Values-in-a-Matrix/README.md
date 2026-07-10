# Day 31 - Cells with Odd Values in a Matrix

## 📝 Problem Statement

There is an `m x n` matrix initialized with all `0`s.

You are given an array `indices`, where each `indices[i] = [ri, ci]`.

For every pair:

- Increment every element in row `ri` by `1`.
- Increment every element in column `ci` by `1`.

Return the number of cells with **odd values** after performing all operations.

---

## 📌 Example

### Input

```text
m = 2
n = 3
indices = [[0,1],[1,1]]
```

### Output

```text
6
```

---

## 💡 Approach

1. Create a matrix of size `m × n` initialized with `0`.
2. For every pair `[row, col]`:
   - Increment all elements in the specified row.
   - Increment all elements in the specified column.
3. Traverse the matrix.
4. Count all cells having odd values.

---

## 🧠 Dry Run

Initial Matrix

```text
0 0 0
0 0 0
```

After `[0,1]`

```text
1 2 1
0 1 0
```

After `[1,1]`

```text
1 3 1
1 3 1
```

Odd-valued cells = **6**

---

## 📊 Complexity Analysis

**Time Complexity:** `O(k × (m + n) + m × n)`

- `k` = number of operations (`indices.length`)

**Space Complexity:** `O(m × n)`

---

## 📚 Concepts Learned

- Matrix Traversal
- Simulation
- Nested Loops
- Array Manipulation

---

## 🎯 Interview Pattern

- Arrays
- Matrix
- Simulation

---

## 🚀 Key Takeaway

This problem demonstrated how to simulate matrix operations efficiently using nested loops. Breaking the task into row updates, column updates, and final counting made the implementation clean and easy to understand.

---

**Language:** Java

**LeetCode:** #1252 – Cells with Odd Values in a Matrix
