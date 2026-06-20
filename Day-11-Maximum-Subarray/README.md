# Day 11 - Maximum Subarray

## Problem

Given an integer array `nums`, find the contiguous subarray with the largest sum and return its sum.

A contiguous subarray is a sequence of elements that appear next to each other in the array.

---

## Example 1

### Input

```java
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

### Output

```java
6
```

### Explanation

The subarray:

```java
[4,-1,2,1]
```

has the largest sum:

```java
4 + (-1) + 2 + 1 = 6
```

---

## Example 2

### Input

```java
nums = [1]
```

### Output

```java
1
```

---

## Example 3

### Input

```java
nums = [5,4,-1,7,8]
```

### Output

```java
23
```

---

## Approach

I used **Kadane's Algorithm**, which efficiently finds the maximum sum subarray in a single pass.

### Idea

At each index:

- Either start a new subarray from the current element.
- Or extend the previous subarray.

Choose whichever gives the larger sum.

---

## Dry Run

Input:

```java
nums = [-2,1,-3,4,-1,2,1,-5,4]
```

Initial:

```java
currentSum = -2
maxSum = -2
```

### i = 1

```java
currentSum = Math.max(1, -2 + 1)
           = 1

maxSum = 1
```

### i = 2

```java
currentSum = Math.max(-3, 1 + (-3))
           = -2

maxSum = 1
```

### i = 3

```java
currentSum = Math.max(4, -2 + 4)
           = 4

maxSum = 4
```

### i = 4

```java
currentSum = 3
maxSum = 4
```

### i = 5

```java
currentSum = 5
maxSum = 5
```

### i = 6

```java
currentSum = 6
maxSum = 6
```

### i = 7

```java
currentSum = 1
maxSum = 6
```

### i = 8

```java
currentSum = 5
maxSum = 6
```

Final Answer:

```java
6
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

- Kadane's Algorithm
- Dynamic Programming Basics
- Greedy Approach
- Array Traversal
- Time Complexity Optimization
- Maximum Subarray Problems

---

## Key Takeaway

Kadane's Algorithm helps find the maximum subarray sum efficiently by deciding at each step whether to continue the current subarray or start a new one.

---

## Language

Java

---

## LeetCode

Problem #53 - Maximum Subarray
