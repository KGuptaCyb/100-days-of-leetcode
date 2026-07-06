# Day 28 - Rotate Array

## Problem

Given an integer array `nums`, rotate the array to the **right** by `k` steps, where `k` is non-negative.

---

## Example 1

### Input

```text
nums = [1,2,3,4,5,6,7]
k = 3
```

### Output

```text
[5,6,7,1,2,3,4]
```

---

## Example 2

### Input

```text
nums = [-1,-100,3,99]
k = 2
```

### Output

```text
[3,99,-1,-100]
```

---

## Approach

I solved this problem using the **Reverse Array Algorithm**, which rotates the array in-place without using any extra space.

### Algorithm

1. Reverse the entire array.
2. Reverse the first `k` elements.
3. Reverse the remaining `n-k` elements.

This efficiently performs a right rotation in **O(n)** time.

---

## Dry Run

### Input

```text
nums = [1,2,3,4,5,6,7]
k = 3
```

### Step 1

Reverse entire array

```text
7 6 5 4 3 2 1
```

### Step 2

Reverse first 3 elements

```text
5 6 7 4 3 2 1
```

### Step 3

Reverse remaining elements

```text
5 6 7 1 2 3 4
```

Final Answer

```text
[5,6,7,1,2,3,4]
```

---

## Time Complexity

```text
O(n)
```

Each element is visited at most once.

---

## Space Complexity

```text
O(1)
```

The array is modified in-place without using extra space.

---

## Concepts Learned

- Arrays
- In-place Algorithms
- Two Pointers
- Reverse Technique
- Modulo Operation
- Helper Functions

---

## Interview Pattern

- Arrays
- Two Pointers
- In-place Manipulation

---

## Key Takeaway

The reverse technique is one of the most elegant ways to rotate an array. Breaking the problem into smaller helper functions made the solution cleaner, easier to debug, and more reusable.

---

## Language

Java

---

## LeetCode

Problem #189 - Rotate Array
