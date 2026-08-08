# Day 60 - Reverse Words in a String

## 📝 Problem Statement

Given an input string `s`, reverse the order of the words.

A word is defined as a sequence of non-space characters.

The returned string should:

- Contain the words in reverse order.
- Have only a single space between words.
- Not contain leading or trailing spaces.

---

## 💡 Approach

I used Java's `split()` method to separate the words and then traversed the resulting array from right to left.

### Steps

1. Split the string using one or more spaces.
2. Start from the last word.
3. Append each word to a `StringBuilder`.
4. Add a space between words.
5. Remove the final trailing space using `trim()`.
6. Return the resulting string.

---
