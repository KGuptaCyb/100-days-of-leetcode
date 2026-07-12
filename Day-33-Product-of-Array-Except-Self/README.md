# Day 33 - Product of Array Except Self

## 📝 Problem Statement

Given an integer array `nums`, return an array `answer` such that:

- `answer[i]` is equal to the product of all the elements of `nums` except `nums[i]`.
- The solution must run in **O(n)** time.
- You **cannot use the division operator**.

---

## 📌 Example

### Input

```text
nums = [1,2,3,4]
```

### Output

```text
[24,12,8,6]
```

---

## 💡 Approach

Instead of calculating the product for every index separately, I used the **Prefix Product** and **Suffix Product** technique.

### Algorithm

1. Create an answer array.
2. Store the product of all elements to the **left** of each index.
3. Traverse the array from right to left while maintaining a running **suffix product**.
4. Multiply the prefix and suffix products to get the final answer.

This avoids nested loops and division while achieving an optimal solution.

---

## 🧠 Dry Run

### Input

```text
nums = [1,2,3,4]
```

### Prefix Products

```text
[1,1,2,6]
```

### Right Products

```text
Start = 1

Index 3 → 6 × 1 = 6

Index 2 → 2 × 4 = 8

Index 1 → 1 × 12 = 12

Index 0 → 1 × 24 = 24
```

### Final Answer

```text
[24,12,8,6]
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n)`

- One pass for prefix products.
- One pass for suffix products.

**Space Complexity:** `O(1)`

(Excluding the output array.)

---

## 📚 Concepts Learned

- Prefix Product
- Suffix Product
- Arrays
- Space Optimization
- In-place Computation

---

## 🎯 Interview Pattern

- Arrays
- Prefix & Suffix
- Dynamic Product Computation

---

## 🚀 Key Takeaway

This problem taught me how prefix and suffix products can replace division while still achieving an optimal **O(n)** solution. It is one of the most common interview patterns for array-based questions.

---

**Language:** Java

**LeetCode:** #238 - Product of Array Except Self
