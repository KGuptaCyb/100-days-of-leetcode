# Day 19 - Sqrt(x)

## Problem

Given a non-negative integer `x`, return the square root of `x` rounded down to the nearest integer.

You must not use any built-in exponent functions such as `Math.sqrt()`.

---

## Example 1

### Input

```java
x = 4
```

### Output

```java
2
```

---

## Example 2

### Input

```java
x = 8
```

### Output

```java
2
```

### Explanation

```text
The square root of 8 is approximately 2.82842...
Since we return only the integer part, the answer is 2.
```

---

## Approach

Instead of checking every number one by one, I used **Binary Search** to find the integer square root efficiently.

### Algorithm

- Handle edge cases where `x` is `0` or `1`.
- Initialize:
  - `left = 1`
  - `right = x`
- Find the middle value.
- Compare `mid × mid` with `x`.
- If equal, return `mid`.
- If `mid²` is smaller, save it as the current answer and search the right half.
- Otherwise, search the left half.
- Return the last valid answer.

---

## Dry Run

Input:

```java
x = 8
```

Initial:

```text
left = 1
right = 8
ans = 0
```

| Left | Right | Mid | Mid² | Action |
|------|-------|-----|------|--------|
|1|8|4|16|Move Right|
|1|3|2|4|ans = 2, Move Left|
|3|3|3|9|Move Right|

Loop ends.

Return:

```java
2
```

---

## Time Complexity

```text
O(log x)
```

Binary Search reduces the search space by half in every iteration.

---

## Space Complexity

```text
O(1)
```

Only a few variables are used.

---

## Concepts Learned

- Binary Search on Answer
- Divide and Conquer
- Integer Overflow Handling
- Mathematical Problem Solving
- Time & Space Optimization

---

## Key Takeaway

This problem showed that Binary Search is not limited to searching in arrays. It can also be applied to find the correct numerical answer efficiently. Using `long` while calculating `mid * mid` prevents integer overflow for large values.

---

## Language

Java

---

## LeetCode

Problem #69 - Sqrt(x)
