# Day 15 - Merge Sorted Array

## Problem

You are given two sorted integer arrays `nums1` and `nums2`, along with two integers `m` and `n` representing the number of valid elements in each array.

Merge `nums2` into `nums1` as one sorted array.

The final sorted array should be stored inside `nums1`.

---

## Example 1

### Input

```java
nums1 = [1,2,3,0,0,0]
m = 3

nums2 = [2,5,6]
n = 3
```

### Output

```java
[1,2,2,3,5,6]
```

---

## Example 2

### Input

```java
nums1 = [1]
m = 1

nums2 = []
n = 0
```

### Output

```java
[1]
```

---

## Example 3

### Input

```java
nums1 = [0]
m = 0

nums2 = [1]
n = 1
```

### Output

```java
[1]
```

---

## Approach

Since both arrays are already sorted, I used the **Two Pointers** technique starting from the **end** of both arrays.

### Algorithm

- `i` points to the last valid element in `nums1`.
- `j` points to the last element in `nums2`.
- `k` points to the last position in `nums1`.

At every step:

- Compare `nums1[i]` and `nums2[j]`.
- Place the larger element at `nums1[k]`.
- Move the corresponding pointer backward.
- Continue until all elements from `nums2` are merged.

---

## Dry Run

Input:

```java
nums1 = [1,2,3,0,0,0]
nums2 = [2,5,6]
```

Initial pointers:

```text
i = 2
j = 2
k = 5
```

| Compare | Place | Updated Array |
|----------|-------|---------------|
|3 vs 6|6|[1,2,3,0,0,6]|
|3 vs 5|5|[1,2,3,0,5,6]|
|3 vs 2|3|[1,2,3,3,5,6]|
|2 vs 2|2|[1,2,2,3,5,6]|

Final Output:

```java
[1,2,2,3,5,6]
```

---

## Time Complexity

```text
O(m + n)
```

Each element is processed exactly once.

---

## Space Complexity

```text
O(1)
```

The merge is performed in-place without using extra memory.

---

## Concepts Learned

- Arrays
- Two Pointers
- In-place Array Modification
- Merging Sorted Arrays
- Interview Pattern
- Time & Space Optimization

---

## Key Takeaway

Instead of merging from the beginning and risking overwriting elements, we merge from the end where empty spaces are available. This allows us to complete the merge efficiently without using extra space.

---

## Language

Java

---

## LeetCode

Problem #88 - Merge Sorted Array
