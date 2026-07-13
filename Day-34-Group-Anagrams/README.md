# Day 34 - Group Anagrams

## 📝 Problem Statement

Given an array of strings `strs`, group the anagrams together. You can return the answer in **any order**.

An **anagram** is a word or phrase formed by rearranging the letters of another word using all the original letters exactly once.

---

## 📌 Example

### Input

```text
strs = ["eat","tea","tan","ate","nat","bat"]
```

### Output

```text
[
  ["bat"],
  ["nat","tan"],
  ["ate","eat","tea"]
]
```

---

## 💡 Approach

Since anagrams contain the same characters, sorting each string produces the same result for all words in the same group.

### Steps

1. Create a `HashMap<String, List<String>>`.
2. Traverse every string in the array.
3. Convert the string into a character array.
4. Sort the character array.
5. Convert it back into a string and use it as the key.
6. Store all strings with the same sorted key in the same list.
7. Return all the grouped lists.

---

## 🧠 Dry Run

### Input

```text
["eat","tea","tan","ate","nat","bat"]
```

Sorted strings:

```text
eat → aet
tea → aet
ate → aet

tan → ant
nat → ant

bat → abt
```

HashMap becomes:

```text
aet → [eat, tea, ate]
ant → [tan, nat]
abt → [bat]
```

Return:

```text
[
 [eat, tea, ate],
 [tan, nat],
 [bat]
]
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n × k log k)`

- `n` = Number of strings
- `k` = Maximum length of a string

**Space Complexity:** `O(n × k)`

---

## 📚 Concepts Learned

- HashMap
- String Manipulation
- Character Arrays
- Sorting
- Grouping Similar Data

---

## 🎯 Interview Pattern

- HashMap
- Strings
- Sorting

---

## 🚀 Key Takeaway

This problem demonstrated how selecting an appropriate key for a `HashMap` can simplify grouping operations. Using the sorted version of each string allowed all anagrams to be grouped efficiently.

---

**Language:** Java

**LeetCode:** #49 - Group Anagrams
