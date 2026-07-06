# Day 27 - Missing Number

## Problem

Given an array `nums` containing `n` distinct numbers in the range `[0, n]`, return the only number in the range that is missing from the array.

---

## Example 1

### Input

```text
nums = [3,0,1]
```

### Output

```text
2
```

---

## Example 2

### Input

```text
nums = [0,1]
```

### Output

```text
2
```

---

## Example 3

### Input

```text
nums = [9,6,4,2,3,5,7,0,1]
```

### Output

```text
8
```

---

## Approach

I solved this problem using the **Mathematical Sum Formula**.

### Idea

- The numbers should be from **0 to n**.
- Calculate the expected sum using the formula:

```text
n × (n + 1) / 2
```

- Calculate the actual sum of the array.
- The difference between the expected sum and the actual sum is the missing number.

---

## Dry Run

### Input

```text
nums = [3,0,1]
```

### Expected Sum

```text
3 × (3 + 1) / 2 = 6
```

### Actual Sum

```text
3 + 0 + 1 = 4
```

### Missing Number

```text
6 - 4 = 2
```

---

## Time Complexity

```text
O(n)
```

One traversal of the array.

---

## Space Complexity

```text
O(1)
```

No extra space is used.

---

## Concepts Learned

- Arrays
- Mathematical Formula
- Iteration
- Problem Solving
- Time & Space Complexity Analysis

---

## Interview Pattern

- Arrays
- Math
- Simulation

---

## Key Takeaway

Sometimes the simplest mathematical approach is the most efficient. By comparing the expected sum of numbers from **0 to n** with the actual sum of the array, we can find the missing element in linear time and constant space.

---

## Language

Java

---

## LeetCode

Problem #268 - Missing Number
