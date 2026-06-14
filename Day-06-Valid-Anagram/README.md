# Day 6 - Valid Anagram

## Problem

Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.

An Anagram is a word or phrase formed by rearranging the letters of another word, using all the original letters exactly once.

---

## Example 1

### Input

```java
s = "anagram"
t = "nagaram"
```

### Output

```java
true
```

---

## Example 2

### Input

```java
s = "rat"
t = "car"
```

### Output

```java
false
```

---

## Approach

I used a frequency array of size 26 to count the occurrences of each lowercase English letter.

### Steps

1. Check if both strings have the same length.
2. Create an integer array of size 26.
3. Traverse both strings simultaneously.
4. Increase the count for characters in `s`.
5. Decrease the count for characters in `t`.
6. If all values in the frequency array become 0, the strings are anagrams.

---

## Dry Run

Input:

```java
s = "ab"
t = "ba"
```

Frequency Updates:

```text
a -> +1
b -> +1

b -> -1
a -> -1
```

Final frequency array:

```text
[0,0,0,0,...]
```

Since all values are 0, the strings are anagrams.

Output:

```java
true
```

---

## Time Complexity

O(n)

Where n is the length of the string.

---

## Space Complexity

O(1)

The frequency array size is fixed at 26.

---

## Concepts Learned

* Strings
* charAt()
* Frequency Counting
* Character Mapping
* Arrays
* Enhanced For Loop
* Time Complexity Analysis

---

## Key Takeaway

Using a frequency array is an efficient way to compare character occurrences and determine whether two strings are anagrams without sorting.

---

## Language

Java

---

## LeetCode

Problem #242 - Valid Anagram
