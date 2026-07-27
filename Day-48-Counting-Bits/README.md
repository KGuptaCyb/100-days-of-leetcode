# Day 48 - Counting Bits

## 📝 Problem Statement

Given an integer `n`, return an array `ans` of length `n + 1` where:

```text
ans[i] = number of 1's in the binary representation of i
```

### Example

```text
Input:
n = 5

Output:
[0,1,1,2,1,2]
```

---

## 💡 Approach

Use Dynamic Programming with Bit Manipulation.

For every number `i`:

```text
ans[i] = ans[i >> 1] + (i & 1)
```

Here:

- `i >> 1` removes the last bit.
- `i & 1` checks whether the last bit is `1`.

Therefore, we can reuse the answer already calculated for `i >> 1`.

---

## 📊 Complexity Analysis

- Time Complexity: O(n)
- Space Complexity: O(n)

---

## 📚 Concepts Learned

- Dynamic Programming
- Bit Manipulation
- Binary Representation
- Right Shift Operator `>>`
- Bitwise AND `&`

---

## 🎯 Key Takeaway

The number of set bits in `i` can be calculated using the already computed result for `i >> 1`.

```text
ans[i] = ans[i >> 1] + (i & 1)
```

This avoids repeatedly counting the bits of every number from scratch.

---

**Language:** Java

**LeetCode:** #338 - Counting Bits
