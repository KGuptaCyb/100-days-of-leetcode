# Day 37 - Insert Interval

## 📝 Problem Statement

You are given a list of non-overlapping intervals sorted by their start times. Insert a new interval into the list while maintaining the sorted order and merge overlapping intervals if necessary.

Return the updated list of intervals.

---

## 📌 Example

### Input

```text
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

### Output

```text
[[1,5],[6,9]]
```

---

## 💡 Approach

The solution can be divided into three phases:

1. Add all intervals that end before the new interval starts.
2. Merge all intervals that overlap with the new interval.
3. Add all remaining intervals.

Since the intervals are already sorted, we only need one traversal.

---

## 🧠 Dry Run

### Input

```text
intervals = [[1,3],[6,9]]
newInterval = [2,5]
```

### Step 1

No interval ends before `2`.

### Step 2

Merge

```text
[1,3] + [2,5] → [1,5]
```

### Step 3

Add remaining interval

```text
[6,9]
```

### Final Output

```text
[[1,5],[6,9]]
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n)`

- Each interval is visited only once.

**Space Complexity:** `O(n)`

- Extra list used to store the result.

---

## 📚 Concepts Learned

- Interval Problems
- Greedy Algorithm
- ArrayList
- 2D Arrays
- Merge Logic

---

## 🎯 Interview Pattern

- Intervals
- Greedy
- Array Traversal

---

## 🚀 Key Takeaway

Breaking the problem into three simple phases—adding non-overlapping intervals, merging overlapping intervals, and appending the remaining intervals—makes the implementation clean, efficient, and easy to understand.

---

**Language:** Java

**LeetCode:** #57 - Insert Interval
