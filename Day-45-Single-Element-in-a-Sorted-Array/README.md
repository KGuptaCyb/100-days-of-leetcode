# Day 45 - Single Element in a Sorted Array

## 📝 Problem Statement

You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears only once.

Find and return the single element that appears only once.

Your solution must run in **O(log n)** time and **O(1)** space.

---

## 💡 Approach

Instead of using XOR, this problem requires a Binary Search solution.

### Key Observation

- Before the unique element, pairs start at **even** indices.
- After the unique element, pairs start at **odd** indices.

Using this observation:

- Make the middle index even.
- Compare `nums[mid]` with `nums[mid + 1]`.
- If they are equal, the single element lies on the right.
- Otherwise, it lies on the left (including `mid`).

This allows us to eliminate half of the search space in each iteration.

---

## 🧠 Dry Run

Input:

nums = [1,1,2,3,3,4,4,8,8]

- left = 0, right = 8
- mid = 4 → make even → 4
- nums[4] = 3, nums[5] = 4 (not equal)
- Move right = 4

Next:

- left = 0, right = 4
- mid = 2
- nums[2] = 2, nums[3] = 3 (not equal)
- Move right = 2

Next:

- left = 0, right = 2
- mid = 1 → make even → 0
- nums[0] = 1, nums[1] = 1 (equal)
- Move left = 2

Now left == right.

Answer = 2

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(log n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search
- Index Parity
- Pattern Recognition
- Sorted Arrays

---

## 🎯 Interview Pattern

- Binary Search
- Searching in Sorted Arrays
- Pattern-Based Search

---

## 🚀 Key Takeaway

A sorted array often contains hidden patterns. Here, observing how duplicate pairs align before and after the unique element allows us to design an efficient Binary Search solution without extra space.

---

**Language:** Java

**LeetCode:** #540 - Single Element in a Sorted Array
