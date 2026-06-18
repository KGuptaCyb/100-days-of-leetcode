# Day 9 - Move Zeroes

## Problem

Given an integer array `nums`, move all `0`s to the end of it while maintaining the relative order of the non-zero elements.

You must do this in-place without making a copy of the array.

---

## Example 1

### Input

```java
nums = [0,1,0,3,12]
```

### Output

```java
[1,3,12,0,0]
```

---

## Example 2

### Input

```java
nums = [0]
```

### Output

```java
[0]
```

---

## Approach

I used the Two Pointers technique.

### Idea

- Pointer `i` traverses the entire array.
- Pointer `j` keeps track of the position where the next non-zero element should be placed.
- Whenever a non-zero element is found, swap it with the element at index `j`.
- Increment `j` after placing a non-zero element.

This ensures that all non-zero elements are moved to the front while zeros naturally shift to the end.

---

## Dry Run

Input:

```java
nums = [0,1,0,3,12]
```

### Step 1

```text
i = 0
nums[i] = 0
Skip
```

### Step 2

```text
i = 1
nums[i] = 1
Swap nums[1] and nums[0]
```

Array:

```text
[1,0,0,3,12]
```

### Step 3

```text
i = 3
nums[i] = 3
Swap nums[3] and nums[1]
```

Array:

```text
[1,3,0,0,12]
```

### Step 4

```text
i = 4
nums[i] = 12
Swap nums[4] and nums[2]
```

Array:

```text
[1,3,12,0,0]
```

Output:

```java
[1,3,12,0,0]
```

---

## Time Complexity

O(n)

Each element is visited exactly once.

---

## Space Complexity

O(1)

No extra array is used.

---

## Concepts Learned

- Arrays
- Two Pointers Technique
- In-place Array Modification
- Swapping Elements
- Time Complexity Analysis
- Space Optimization

---

## Key Takeaway

The Two Pointers technique helps solve array manipulation problems efficiently while maintaining constant extra space.

---

## Language

Java

---

## LeetCode

Problem #283 - Move Zeroes
