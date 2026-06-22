# Day 13 - Remove Element

## Problem

Given an integer array `nums` and an integer `val`, remove all occurrences of `val` in-place.

Return the number of elements that are **not equal** to `val`.

The order of elements may change, and you must use **O(1)** extra space.

---

## Example 1

### Input

```java
nums = [3,2,2,3]
val = 3
```

### Output

```java
2
```

Modified Array:

```java
[2,2,_,_]
```

---

## Example 2

### Input

```java
nums = [0,1,2,2,3,0,4,2]
val = 2
```

### Output

```java
5
```

Modified Array:

```java
[0,1,3,0,4,_,_,_]
```

---

## Approach

I used the **Two Pointers** technique.

- `i` traverses the entire array.
- `k` keeps track of the position where the next valid element should be placed.
- If the current element is **not equal** to `val`, copy it to index `k` and increment `k`.
- Finally, return `k`, which represents the number of valid elements.

---

## Dry Run

Input:

```java
nums = [4,1,4,2]
val = 4
```

Initially:

```text
k = 0
```

### i = 0

```
nums[0] = 4
```

Equal to `val`.

Skip.

---

### i = 1

```
nums[1] = 1
```

Not equal to `val`.

Copy:

```java
nums[k] = nums[i];
```

Array becomes:

```text
[1,1,4,2]
```

Increment:

```text
k = 1
```

---

### i = 2

```
nums[2] = 4
```

Skip.

---

### i = 3

```
nums[3] = 2
```

Copy:

```text
[1,2,4,2]
```

Increment:

```text
k = 2
```

Return:

```java
2
```

---

## Time Complexity

```text
O(n)
```

The array is traversed only once.

---

## Space Complexity

```text
O(1)
```

No extra array is used.

---

## Concepts Learned

- Arrays
- Two Pointers
- In-place Array Modification
- Array Traversal
- Time Complexity Optimization
- Space Optimization

---

## Key Takeaway

When a problem asks for an in-place solution, we don't delete elements from the array. Instead, we overwrite unwanted elements and return the count of valid elements.

---

## Language

Java

---

## LeetCode

Problem #27 - Remove Element
