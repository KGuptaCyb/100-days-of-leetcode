# Day 17 - Search Insert Position

## Problem

Given a sorted array of distinct integers and a target value, return the index if the target is found.

If not, return the index where it would be inserted while maintaining the sorted order.

You must write an algorithm with **O(log n)** runtime complexity.

---

## Example 1

### Input

```java
nums = [1,3,5,6]
target = 5
```

### Output

```java
2
```

---

## Example 2

### Input

```java
nums = [1,3,5,6]
target = 2
```

### Output

```java
1
```

Explanation:

```text
2 should be inserted before 3.
```

---

## Example 3

### Input

```java
nums = [1,3,5,6]
target = 7
```

### Output

```java
4
```

Explanation:

```text
7 should be inserted at the end.
```

---

## Approach

Since the array is sorted, I used the **Binary Search** algorithm.

### Algorithm

- Initialize two pointers:
  - `left = 0`
  - `right = nums.length - 1`
- Find the middle element.
- If the middle element equals the target, return its index.
- If the target is greater, search the right half.
- Otherwise, search the left half.
- If the target is not found, return `left`, which represents the correct insertion position.

---

## Dry Run

Input:

```java
nums = [1,3,5,6]
target = 2
```

Initial:

```text
left = 0
right = 3
```

| Left | Right | Mid | nums[mid] | Action |
|------|-------|-----|-----------|--------|
|0|3|1|3|Move Right|
|0|0|0|1|Move Left|

Loop ends:

```text
left = 1
right = 0
```

Return:

```java
1
```

---

## Time Complexity

```text
O(log n)
```

The search space is reduced by half after every iteration.

---

## Space Complexity

```text
O(1)
```

Only a few variables are used.

---

## Concepts Learned

- Binary Search
- Divide and Conquer
- Sorted Arrays
- Searching Algorithms
- Finding Insertion Position
- Time & Space Optimization

---

## Key Takeaway

This problem showed that Binary Search can be used not only to find an element but also to determine where a new element should be inserted while maintaining sorted order.

When the target is not found, the `left` pointer naturally indicates the correct insertion position.

---

## Language

Java

---

## LeetCode

Problem #35 - Search Insert Position
