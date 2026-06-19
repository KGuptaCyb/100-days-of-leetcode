# Day 10 - Single Number

## Problem

Given a non-empty array of integers, every element appears twice except for one.

Find that single element.

You must implement a solution with linear runtime complexity and use only constant extra space.

---

## Example 1

### Input

```java
nums = [2,2,1]
```

### Output

```java
1
```

---

## Example 2

### Input

```java
nums = [4,1,2,1,2]
```

### Output

```java
4
```

---

## Approach

I used the XOR (^) operator to solve this problem efficiently.

### XOR Properties

```java
a ^ a = 0
a ^ 0 = a
```

Since every duplicate number appears twice:

```java
2 ^ 2 = 0
1 ^ 1 = 0
```

All duplicate numbers cancel each other out, leaving only the unique number.

---

## Dry Run

Input:

```java
nums = [4,1,2,1,2]
```

Initial:

```java
result = 0
```

Step 1:

```java
0 ^ 4 = 4
```

Step 2:

```java
4 ^ 1 = 5
```

Step 3:

```java
5 ^ 2 = 7
```

Step 4:

```java
7 ^ 1 = 6
```

Step 5:

```java
6 ^ 2 = 4
```

Final Answer:

```java
4
```

---

## Time Complexity

```text
O(n)
```

The array is traversed once.

---

## Space Complexity

```text
O(1)
```

Only one variable is used.

---

## Concepts Learned

- Bit Manipulation
- XOR Operator (^)
- Array Traversal
- Space Optimization
- Interview Problem Solving

---

## Key Takeaway

The XOR operator is a powerful tool for solving problems involving pairs and unique elements. Understanding XOR can help solve many coding interview questions efficiently.

---

## Language

Java

---

## LeetCode

Problem #136 - Single Number
