# Day 12 - Remove Duplicates from Sorted Array

## Problem

Given a sorted integer array `nums`, remove the duplicates **in-place** such that each unique element appears only once.

Return the number of unique elements (`k`).

The relative order of the elements should be maintained.

---

## Example 1

### Input

```java
nums = [1,1,2]
```

### Output

```java
2
```

Modified Array:

```java
[1,2,_]
```

---

## Example 2

### Input

```java
nums = [0,0,1,1,1,2,2,3,3,4]
```

### Output

```java
5
```

Modified Array:

```java
[0,1,2,3,4,_,_,_,_,_]
```

---

## Approach

Since the array is already sorted, duplicate elements always appear next to each other.

I used the **Two Pointers** technique:

- `i` keeps track of the last unique element.
- `j` traverses the array.
- Whenever a new unique element is found, move `i` forward and copy the new value to that position.

Finally, return `i + 1`, which represents the number of unique elements.

---

## Dry Run

Input:

```java
nums = [1,1,2,3,3]
```

Initially:

```text
i = 0
j = 1
```

### Step 1

```
nums[0] == nums[1]
```

Duplicate found.

Move `j`.

---

### Step 2

```
nums[0] != nums[2]
```

Move `i` and copy:

```java
nums[i] = nums[j];
```

Array becomes:

```text
[1,2,2,3,3]
```

---

### Step 3

```
nums[1] != nums[3]
```

Copy again.

Array becomes:

```text
[1,2,3,3,3]
```

Return:

```java
3
```

---

## Time Complexity

```text
O(n)
```

Each element is visited exactly once.

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
- Sorted Arrays
- Time Complexity Analysis
- Space Optimization

---

## Key Takeaway

When an array is sorted, duplicate elements appear together. The Two Pointers technique efficiently overwrites duplicates without using extra memory.

---

## Language

Java

---

## LeetCode

Problem #26 - Remove Duplicates from Sorted Array
