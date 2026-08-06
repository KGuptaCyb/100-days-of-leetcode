# Day 58 - Remove K Digits

## 📝 Problem Statement

Given a non-negative integer represented as a string `num` and an integer `k`, remove `k` digits from the number so that the new number is the smallest possible.

Return the resulting number as a string.

---

## 💡 Approach

This problem is solved using a **Monotonic Increasing Stack**.

### Algorithm

1. Traverse each digit in the string.
2. While the current digit is smaller than the top of the stack and `k > 0`, remove the larger digit.
3. Push the current digit onto the stack.
4. If `k` removals are still left, remove digits from the end of the stack.
5. Build the final number.
6. Remove leading zeros.
7. Return `"0"` if the result becomes empty.

This greedy approach ensures the smallest possible number.

---

## 📊 Complexity Analysis

- **Time Complexity:** O(n)
- **Space Complexity:** O(n)

---

## 📚 Concepts Learned

- Monotonic Increasing Stack
- Greedy Algorithm
- String Manipulation
- Stack Operations
- Handling Leading Zeros

---

## 🎯 Key Takeaway

Using a monotonic increasing stack allows us to greedily remove larger digits before smaller ones, producing the smallest possible number after exactly `k` removals.

---

### 🚀 Problem Information

- **Platform:** LeetCode
- **Problem:** 402. Remove K Digits
- **Difficulty:** Medium
- **Language:** Java
