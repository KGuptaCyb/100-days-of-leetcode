# Day 63 - Longest Repeating Character Replacement

## 📝 Problem Statement

Given a string `s` consisting of uppercase English letters and an integer `k`, you can change at most `k` characters to any other uppercase English character.

Return the length of the longest substring that can contain the same letter after at most `k` replacements.

---

## 💡 Approach

I solved this problem using the **Sliding Window** technique.

For each window, I maintain:

* The frequency of every character.
* The frequency of the most common character in the current window.
* The left and right boundaries of the window.

The number of replacements required is:

```text
windowLength - maxFrequency
```

If the required replacements become greater than `k`, the window is no longer valid, so the left pointer is moved forward.

---

## 🔑 Algorithm

1. Create an array of size 26 to store character frequencies.
2. Use two pointers, `left` and `right`, to represent the sliding window.
3. Expand the window by moving `right`.
4. Update the frequency of the current character.
5. Keep track of the highest character frequency.
6. Calculate the number of replacements required.
7. If replacements exceed `k`, shrink the window from the left.
8. Keep track of the maximum valid window length.

---

## 🔍 Example

### Input

```text
s = "AABABBA"
k = 1
```

### Output

```text
4
```

A substring of length 4 can be converted into four identical characters using at most one replacement.

---

## 📊 Complexity Analysis

* **Time Complexity:** O(n)
* **Space Complexity:** O(1)

Since the input contains only uppercase English letters, the frequency array always contains only 26 elements.

---

## 📚 Concepts Learned

* Sliding Window
* Two Pointers
* Frequency Array
* Hashing Concept
* Window Expansion and Contraction
* Optimizing String Problems

---

## 🎯 Key Takeaway

The important observation is:

```text
Required Replacements =
Window Length - Maximum Character Frequency
```

If the required replacements are within `k`, the current window can be transformed into a string containing the same character.

This allows the problem to be solved efficiently in linear time.

---

## 🚀 100 Days of LeetCode

**Day 63 completed! 🎯**

Continuing to strengthen DSA fundamentals by learning one new pattern at a time.

### Problem Information

* **LeetCode:** 424
* **Problem:** Longest Repeating Character Replacement
* **Difficulty:** Medium
* **Language:** Java
* **Pattern:** Sliding Window + Two Pointers
