# Day 18 - First Bad Version

## Problem

You are a product manager and currently leading a team to develop a new product.

Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all versions after a bad version are also bad.

Given `n` versions and an API:

```java
boolean isBadVersion(version)
```

Return the **first bad version**.

---

## Example

### Input

```java
n = 5
firstBadVersion = 4
```

### Versions

```text
1   2   3   4   5
G   G   G   B   B
```

### Output

```java
4
```

---

## Approach

Since the versions follow a monotonic pattern (Good → Bad), I used the **Binary Search** algorithm.

### Algorithm

- Initialize two pointers:
  - `left = 1`
  - `right = n`
- Find the middle version.
- If the current version is bad, it could be the first bad version, so continue searching on the left.
- Otherwise, search on the right.
- Continue until `left == right`.
- Return `left` as the first bad version.

---


## Dry Run

Input:

```java
n = 5
firstBadVersion = 4
```

Versions:

```text
1  2  3  4  5
G  G  G  B  B
```

| Left | Right | Mid | Version Status | Action |
|------|-------|-----|----------------|--------|
|1|5|3|Good|Move Left = 4|
|4|5|4|Bad|Move Right = 4|

Loop ends:

```text
left = 4
right = 4
```

Return:

```java
4
```

---

## Time Complexity

```text
O(log n)
```

The search space is reduced by half in every iteration.

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
- Monotonic Search Space
- First Occurrence Search
- API-Based Problems
- Time & Space Optimization

---

## Key Takeaway

This problem taught me that Binary Search is not only used to search for values but also to find the first position where a condition changes.

If the current version is bad, it may still be the first bad version, so we keep it in the search space by updating:

```java
right = mid;
```

instead of

```java
right = mid - 1;
```

---

## Language

Java

---

## LeetCode

Problem #278 - First Bad Version
