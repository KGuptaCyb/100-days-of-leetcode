# Day 53 - Subarray Sum Equals K

## 📝 Problem Statement

Given an integer array `nums` and an integer `k`, return the total number of continuous subarrays whose sum equals `k`.

---

## 💡 Approach

This problem is efficiently solved using the Prefix Sum and HashMap technique.

- Maintain a running prefix sum.
- Store the frequency of each prefix sum in a HashMap.
- For each element, check if `(currentSum - k)` exists in the map.
- If it exists, add its frequency to the answer.
- Update the frequency of the current prefix sum.

This allows us to count all valid subarrays in a single traversal.

---

## 📊 Complexity

- Time Complexity: **O(n)**
- Space Complexity: **O(n)**

---

## 📚 Concepts Learned

- Prefix Sum
- HashMap
- Array Traversal
- Frequency Counting
- Optimization

---

## 🎯 Key Takeaway

Using prefix sums with a HashMap transforms a quadratic solution into a linear one, making it a powerful pattern for solving subarray sum problems efficiently.

**Language:** Java

**LeetCode:** #560 - Subarray Sum Equals K
