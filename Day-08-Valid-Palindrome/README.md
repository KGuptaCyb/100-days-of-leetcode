# Day 8 - Valid Palindrome

## Problem

Given a string `s`, determine whether it is a palindrome after:

- Converting all uppercase letters to lowercase.
- Removing all non-alphanumeric characters.

Return `true` if it is a palindrome, otherwise return `false`.

---

## Example 1

### Input

```java
s = "A man, a plan, a canal: Panama"
```

### Output

```java
true
```

### Explanation

After removing special characters and converting to lowercase:

```text
amanaplanacanalpanama
```

It reads the same forward and backward.

---

## Example 2

### Input

```java
s = "race a car"
```

### Output

```java
false
```

---

## Approach

I used the Two Pointers technique.

### Steps

1. Initialize two pointers:
   - `left` at the beginning.
   - `right` at the end.
2. Skip characters that are not letters or digits.
3. Convert characters to lowercase.
4. Compare both characters.
5. If they don't match, return `false`.
6. Move both pointers inward.
7. If all characters match, return `true`.

---

## Dry Run

Input:

```java
s = "racecar"
```

Comparisons:

```text
r == r
a == a
c == c
```

All characters match.

Output:

```java
true
```

---

## Time Complexity

O(n)

Each character is visited at most once.

---

## Space Complexity

O(1)

No extra data structure is used.

---

## Concepts Learned

- Two Pointers
- String Traversal
- Character.isLetterOrDigit()
- Character.toLowerCase()
- String Manipulation
- Time Complexity Analysis

---

## Key Takeaway

The Two Pointers technique is an efficient way to solve palindrome-related problems while using constant extra space.

---

## Language

Java

---

## LeetCode

Problem #125 - Valid Palindrome
