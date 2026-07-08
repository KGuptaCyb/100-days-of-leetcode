# Day 29 - Find Pivot Index

## Problem

Given an integer array `nums`, return the leftmost pivot index where the sum of all elements to the left is equal to the sum of all elements to the right.

If no such index exists, return `-1`.

---

## Example

### Input

```text
nums = [1,7,3,6,5,6]
```

### Output

```text
3
```

---

## Approach

1. Calculate the total sum of the array.
2. Traverse the array while maintaining a running left sum.
3. Calculate the right sum using:

```text
Right Sum = Total Sum − Left Sum − Current Element
```

4. If left sum equals right sum, return the current index.
5. Otherwise, update the left sum and continue.

---

## Time Complexity

```text
O(n)
```

---

## Space Complexity

```text
O(1)
```

---

## Concepts Learned

- Arrays
- Prefix Sum
- Running Sum
- Constant Space Optimization

---

## Interview Pattern

- Arrays
- Prefix Sum

---

## Language

Java

---

## LeetCode

Problem #724 - Find Pivot Index
