# Day 40 - Find Minimum in Rotated Sorted Array

## 📝 Problem Statement

Given a rotated sorted array of distinct integers, return the minimum element.

Your solution must run in **O(log n)** time.

---

## 💡 Approach

This problem can be solved using **Modified Binary Search**.

- Compare the middle element with the rightmost element.
- If `nums[mid] > nums[right]`, search the right half.
- Otherwise, search the left half including `mid`.
- Continue until only one element remains.

---


## 🧠 Dry Run

Input:

```text
nums = [4,5,6,7,0,1,2]
```

Iterations:

```text
mid = 7 > 2 → search right

left = 4

mid = 1 < 2 → search left

right = 5

mid = 0 < 1 → search left

right = 4
```

Result:

```text
0
```

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Modified Binary Search
- Rotated Sorted Arrays
- Search Space Reduction
- Divide and Conquer

---

## 🎯 Interview Pattern

- Binary Search
- Rotated Arrays

---

## 🚀 Key Takeaway

Comparing the middle element with the rightmost element helps determine which side contains the minimum. This enables an efficient binary search solution without scanning the entire array.

---

**Language:** Java

**LeetCode:** #153 - Find Minimum in Rotated Sorted Array
