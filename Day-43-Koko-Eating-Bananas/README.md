# Day 43 - Koko Eating Bananas

## 📝 Problem Statement

Given banana piles and the number of hours `h`, determine the minimum eating speed required for Koko to finish all bananas within `h` hours.

---

## 💡 Approach

Use **Binary Search on the answer**.

- Search between `1` and the largest pile.
- For each speed, calculate the total hours required.
- If the speed is sufficient, search for a smaller valid speed.
- Otherwise, increase the speed.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n log M)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Binary Search on Answer
- Search Space Optimization
- Ceiling Division
- Greedy Validation

---

## 🎯 Interview Pattern

- Binary Search
- Optimization Problems

---

## 🚀 Key Takeaway

Instead of searching for the answer directly, binary search can be applied to the range of possible answers. This "Binary Search on Answer" technique is widely used in optimization problems.

---

**Language:** Java

**LeetCode:** #875 - Koko Eating Bananas
