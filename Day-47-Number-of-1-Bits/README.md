# Day 47 - Number of 1 Bits

## 📝 Problem Statement

Given a positive integer `n`, return the number of `1` bits in its binary representation.

### Example

```text
Input: n = 11

Binary representation: 1011

Output: 3
```

---

## 💡 Approach

Use the bit manipulation technique:

```text
n & (n - 1)
```

This removes the rightmost set bit (`1`) from `n`.

Repeat this operation until `n` becomes `0` and count the number of operations.

## 🧠 Key Concept

For any integer:

```text
n & (n - 1)
```

removes the rightmost `1` bit.

For example:

```text
1011
1010
----
1010
```

One set bit is removed.

---

## 📊 Complexity Analysis

- Time Complexity: `O(k)`, where `k` is the number of set bits
- Space Complexity: `O(1)`

Since Java `int` contains at most 32 bits, the number of iterations is at most 32.

---

## 📚 Concepts Learned

- Bit Manipulation
- Binary Representation
- AND Operator
- Set Bits
- `n & (n - 1)` Trick

---

## 🎯 Key Takeaway

The expression `n & (n - 1)` is a powerful bit manipulation technique that removes the lowest set bit from an integer.

---

**Language:** Java

**LeetCode:** #191 - Number of 1 Bits
