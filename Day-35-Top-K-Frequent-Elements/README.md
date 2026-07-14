# Day 35 - Top K Frequent Elements

## 📝 Problem Statement

Given an integer array `nums` and an integer `k`, return the `k` most frequent elements.

You may return the answer in **any order**.

---

## 📌 Example

### Input

```text
nums = [1,1,1,2,2,3]
k = 2
```

### Output

```text
[1,2]
```

---

## 💡 Approach

To solve this problem efficiently:

1. Use a **HashMap** to count the frequency of each element.
2. Store all unique elements in a **Max Heap (Priority Queue)** ordered by their frequencies.
3. Remove the top `k` elements from the heap and store them in the result array.

This avoids sorting the entire array and focuses only on the frequency of each unique element.

---

## 🧠 Dry Run

### Input

```text
nums = [1,1,1,2,2,3]
k = 2
```

### Frequency Map

```text
1 → 3
2 → 2
3 → 1
```

### Max Heap

```text
Top
 ↓
1
2
3
```

Remove the first `k` elements:

```text
1
2
```

### Final Answer

```text
[1,2]
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n log n)`

- Building the HashMap takes `O(n)`.
- Inserting elements into the Priority Queue takes `O(n log n)`.
- Removing the top `k` elements takes `O(k log n)`.

**Space Complexity:** `O(n)`

- HashMap stores frequencies.
- Priority Queue stores unique elements.

---

## 📚 Concepts Learned

- HashMap
- Frequency Counting
- Priority Queue (Max Heap)
- Custom Comparator
- Heap Operations

---

## 🎯 Interview Pattern

- HashMap
- Heap / Priority Queue
- Top K Elements

---

## 🚀 Key Takeaway

This problem demonstrated how combining a **HashMap** with a **Priority Queue** can efficiently solve frequency-based problems. It reinforced the importance of selecting the appropriate data structure instead of relying on brute-force sorting.

---

**Language:** Java

**LeetCode:** #347 - Top K Frequent Elements
