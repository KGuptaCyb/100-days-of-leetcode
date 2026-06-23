# Day 14 - Majority Element

## Problem

Given an integer array `nums` of size `n`, return the **majority element**.

The majority element is the element that appears **more than ⌊n / 2⌋ times**.

You may assume that the majority element always exists in the array.

---

## Example 1

### Input

```java
nums = [3,2,3]
```

### Output

```java
3
```

---

## Example 2

### Input

```java
nums = [2,2,1,1,1,2,2]
```

### Output

```java
2
```

---

## Approach

I used the **Boyer-Moore Voting Algorithm**, which efficiently finds the majority element without using extra space.

### Algorithm

- Maintain two variables:
  - `candidate` → stores the potential majority element.
  - `count` → tracks the vote count.
- If `count` becomes `0`, choose the current number as the new candidate.
- If the current number equals the candidate, increment `count`.
- Otherwise, decrement `count`.
- At the end, the candidate is the majority element.

---

## Dry Run

Input:

```java
nums = [2,2,1,1,1,2,2]
```

Initial:

```text
candidate = 0
count = 0
```

| Current Number | Candidate | Count |
|---------------|-----------|-------|
|2|2|1|
|2|2|2|
|1|2|1|
|1|2|0|
|1|1|1|
|2|1|0|
|2|2|1|

Final Answer:

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

Only two variables are used.

---

## Concepts Learned

- Arrays
- Boyer-Moore Voting Algorithm
- Majority Element
- Space Optimization
- Interview Pattern
- Time Complexity Analysis

---

## Key Takeaway

The Boyer-Moore Voting Algorithm works by canceling out different elements. Since the majority element appears more than half the time, it can never be completely canceled and remains the final candidate.

---

## Language

Java

---

## LeetCode

Problem #169 - Majority Element
