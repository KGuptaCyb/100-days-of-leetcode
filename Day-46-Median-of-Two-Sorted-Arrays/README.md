# Day 46 - Median of Two Sorted Arrays

## 📝 Problem Statement

Given two sorted arrays, find the median of the combined sorted array in `O(log(min(m, n)))` time.

---

## 💡 Approach

Instead of merging the arrays, perform Binary Search on the smaller array.

- Partition both arrays.
- Ensure every element in the left partitions is less than or equal to every element in the right partitions.
- Compute the median based on the total number of elements.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(log(min(m, n)))`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search
- Partitioning
- Divide and Conquer
- Median Finding

---

## 🎯 Interview Pattern

- Binary Search on Two Arrays
- Advanced Searching

---

## 🚀 Key Takeaway

Partitioning two sorted arrays allows us to find the median efficiently without merging them, making this one of the most elegant Binary Search problems.

---

**Language:** Java

**LeetCode:** #4 - Median of Two Sorted Arrays
