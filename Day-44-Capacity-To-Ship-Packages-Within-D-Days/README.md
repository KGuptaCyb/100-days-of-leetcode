# Day 44 - Capacity To Ship Packages Within D Days

## 📝 Problem Statement

Given an array of package weights and a number of days, determine the minimum ship capacity required to deliver all packages within the given days while maintaining the order of packages.

---

## 💡 Approach

Use **Binary Search on the Answer**.

- Minimum capacity = Maximum package weight.
- Maximum capacity = Sum of all package weights.
- Simulate shipping for each candidate capacity.
- If the shipment finishes within the given days, search for a smaller capacity.
- Otherwise, increase the capacity.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n log S)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search on Answer
- Greedy Simulation
- Search Space Optimization
- Array Traversal

---

## 🎯 Interview Pattern

- Binary Search
- Optimization Problems

---

## 🚀 Key Takeaway

When asked to find the minimum or maximum feasible value, Binary Search on the answer space is often the optimal approach. Combining it with a validation function leads to an efficient solution.

---

**Language:** Java

**LeetCode:** #1011 - Capacity To Ship Packages Within D Days
