# Day 32 - Two Sum II (Input Array Is Sorted)

## 📝 Problem Statement

Given a **1-indexed** array of integers `numbers` that is sorted in non-decreasing order, find two numbers such that they add up to a specific `target` number.

Return the indices of the two numbers as an integer array of size 2.

The tests are generated such that there is **exactly one solution**, and the same element cannot be used twice.

---

## 📌 Example

### Input

```text
numbers = [2,7,11,15]
target = 9
```

### Output

```text
[1,2]
```

---

## 💡 Approach

Since the array is already sorted, I used the **Two Pointer** technique.

- Place one pointer at the beginning (`i`).
- Place another pointer at the end (`j`).
- Calculate the sum of both elements.
- If the sum equals the target, return their 1-based indices.
- If the sum is greater than the target, move the right pointer left.
- Otherwise, move the left pointer right.

This avoids using extra space like a HashMap and solves the problem efficiently.

---

## 🧠 Dry Run

### Input

```text
numbers = [2,7,11,15]
target = 9
```

Initial Pointers

```text
i = 0 (2)
j = 3 (15)
```

Sum = 17 → Too large

Move right pointer

```text
j = 2
```

Sum = 13 → Too large

Move right pointer

```text
j = 1
```

Sum = 9 ✅

Return

```text
[1,2]
```

---

## 📊 Complexity Analysis

### Time Complexity

```
O(n)
```

Each pointer moves at most once across the array.

### Space Complexity

```
O(1)
```

No extra data structures are used.

---

## 📚 Concepts Learned

- Two Pointer Technique
- Sorted Arrays
- Greedy Pointer Movement
- Index vs Value
- Space Optimization

---

## 🎯 Interview Pattern

- Arrays
- Two Pointers
- Sorted Array

---

## 🚀 Key Takeaway

This problem showed how the sorted nature of an array can be used to avoid extra space. The Two Pointer technique provides a clean and efficient solution with linear time complexity.

---

**Language:** Java

**LeetCode:** #167 - Two Sum II (Input Array Is Sorted)
