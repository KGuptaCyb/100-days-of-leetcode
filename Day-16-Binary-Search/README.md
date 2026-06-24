# Day 16 - Binary Search

## Problem

Given a sorted array of integers `nums` and an integer `target`, return the index of `target` if it exists. Otherwise, return `-1`.

You must write an algorithm with **O(log n)** runtime complexity.

---

## Example 1

### Input

```java
nums = [-1,0,3,5,9,12]
target = 9
```

### Output

```java
4
```

---

## Example 2

### Input

```java
nums = [-1,0,3,5,9,12]
target = 2
```

### Output

```java
-1
```

---

## Approach

Since the array is already sorted, I used the **Binary Search** algorithm.

### Algorithm

- Initialize two pointers:
  - `left = 0`
  - `right = nums.length - 1`
- Find the middle element.
- If the middle element equals the target, return its index.
- If the target is greater, search the right half.
- Otherwise, search the left half.
- Repeat until the target is found or the search space becomes empty.

---

## Dry Run

Input:

```java
nums = [-1,0,3,5,9,12]
target = 9
```

Initial:

```text
left = 0
right = 5
```

| Left | Right | Mid | nums[mid] | Action |
|------|-------|-----|-----------|--------|
|0|5|2|3|Search Right|
|3|5|4|9|Target Found|

Return:

```java
4
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
- Searching in Sorted Arrays
- Time Optimization
- Space Optimization
- Interview Pattern

---

## Key Takeaway

Binary Search is much faster than Linear Search for sorted arrays. By repeatedly dividing the search space into half, it achieves a time complexity of **O(log n)**, making it ideal for searching large datasets efficiently.

---

## Language

Java

---

## LeetCode

Problem #704 - Binary Search
