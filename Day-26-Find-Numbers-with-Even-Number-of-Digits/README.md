# Day 26 - Find Numbers with Even Number of Digits

## Problem

Given an array `nums` of integers, return how many of them contain an even number of digits.

---

## Example 1

### Input

```text
nums = [12,345,2,6,7896]
```

### Output

```text
2
```

### Explanation

- 12 → 2 digits ✅
- 345 → 3 digits
- 2 → 1 digit
- 6 → 1 digit
- 7896 → 4 digits ✅

Total numbers with even digits = **2**

---

## Example 2

### Input

```text
nums = [555,901,482,1771]
```

### Output

```text
1
```

---

## Approach

For every number in the array:

1. Count the number of digits by repeatedly dividing the number by 10.
2. Check whether the digit count is even.
3. If yes, increment the answer.
4. Return the final count.

---

## Dry Run

### Input

```text
nums = [12,345,2,6,7896]
```

### Processing

| Number | Digits | Even? |
|--------:|:------:|:------:|
| 12 | 2 | ✅ |
| 345 | 3 | ❌ |
| 2 | 1 | ❌ |
| 6 | 1 | ❌ |
| 7896 | 4 | ✅ |

Answer = **2**

---

## Time Complexity

```text
O(n × d)
```

Where:

- `n` = number of elements
- `d` = number of digits in each number

Since the maximum number of digits is very small, this is effectively **O(n)**.

---

## Space Complexity

```text
O(1)
```

No extra space is used.

---

## Concepts Learned

- Arrays
- Digit Manipulation
- Integer Division
- Counting Digits
- Time Complexity Analysis

---

## Key Takeaway

A simple digit-counting approach can efficiently determine whether a number has an even number of digits. This problem reinforces working with integers using arithmetic operations instead of converting them into strings.

---

## Language

Java

---

## LeetCode

Problem #1295 - Find Numbers with Even Number of Digits
