# Day 5 - Contains Duplicate

## Problem

Given an integer array `nums`, return `true` if any value appears at least twice in the array, and return `false` if every element is distinct.

---

## Example 1

### Input

```java
nums = [1,2,3,1]
```

### Output

```java
true
```

### Explanation

The number `1` appears more than once in the array.

---

## Example 2

### Input

```java
nums = [1,2,3,4]
```

### Output

```java
false
```

### Explanation

All elements in the array are unique.

---

## Approach

To efficiently detect duplicates, I used a **HashSet**.

### Steps

1. Create an empty HashSet.
2. Traverse the array using an enhanced for loop.
3. For each element:

   * Check whether it already exists in the HashSet.
   * If it exists, return `true`.
   * Otherwise, add it to the HashSet.
4. If the loop completes without finding duplicates, return `false`.

This approach avoids comparing every element with every other element and significantly improves performance.

---

## Time Complexity

```text
O(n)
```

The array is traversed only once.

---

## Space Complexity

```text
O(n)
```

A HashSet is used to store previously seen elements.

---

## Concepts Learned

* HashSet
* Java Collections Framework
* Fast Lookup Operations
* Enhanced For Loop
* Duplicate Detection
* Time Complexity Optimization

---

## Key Takeaway

Using the right data structure can significantly improve efficiency. A HashSet provides constant-time lookup on average, making it ideal for detecting duplicates in an array.

---

## Language

Java

---

## LeetCode

Problem #217 - Contains Duplicate

