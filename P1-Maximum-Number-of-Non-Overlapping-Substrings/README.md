# 1520 – Maximum Number of Non-Overlapping Substrings

## Problem

Given a string `s` containing lowercase English letters, find the maximum number of non-empty substrings such that:

1. The substrings do not overlap.
2. If a substring contains a character, it must contain **all occurrences** of that character in the original string.
3. If multiple solutions contain the same maximum number of substrings, choose the one with the **minimum total length**.

**LeetCode:** 1520 – Maximum Number of Non-Overlapping Substrings
**Difficulty:** Hard

---

## Approach

Since the string contains only lowercase English letters, we can store the **first** and **last** occurrence of each character.

### Steps

1. Find the first and last occurrence of every character.
2. For each character, create the smallest possible valid substring starting from its first occurrence.
3. Expand the substring whenever a character inside it has a later last occurrence.
4. If a character inside the substring appears before the starting position, the substring is invalid.
5. Store all valid intervals.
6. Sort the intervals by their ending position.
7. Greedily select non-overlapping intervals by choosing the one that ends earliest.

---

## Example

### Input

```text
s = "adefaddaccc"
```

Possible valid substrings include:

```text
"adefadda"
"ef"
"e"
"f"
"ccc"
```

The maximum number of non-overlapping substrings is:

```text
["e", "f", "ccc"]
```

So the answer contains **3 substrings**.

---

## Key Idea

For every character, we try to construct its smallest valid interval.

If we encounter a character whose last occurrence lies outside the current interval, we extend the interval.

For example:

```text
a → [0, 6]
d → last occurrence = 7
```

So the interval expands:

```text
[0, 6] → [0, 7]
```

giving:

```text
"adefadda"
```

However, starting from `e` gives:

```text
"e"
```

which is a smaller valid substring and allows more non-overlapping substrings to be selected.

---

## Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

The space is constant because there are only **26 lowercase English letters**.

---

## What I Learned

* How to use first and last occurrence arrays.
* How to construct valid intervals by expanding their boundaries.
* How interval scheduling can be used to select maximum non-overlapping substrings.
* How greedy algorithms can help maximize the number of non-overlapping intervals.

---

## Language

**Java**
