# Day 36 - Merge Intervals

## 📝 Problem Statement

Given an array of intervals where `intervals[i] = [starti, endi]`, merge all overlapping intervals and return an array of the non-overlapping intervals.

---

## 📌 Example

### Input

```text
intervals = [[1,3],[2,6],[8,10],[15,18]]
```

### Output

```text
[[1,6],[8,10],[15,18]]
```

### Explanation

- `[1,3]` and `[2,6]` overlap, so they are merged into `[1,6]`.

---

## 💡 Approach

To efficiently merge intervals:

1. Sort the intervals based on their starting values.
2. Create a list to store the merged intervals.
3. Traverse each interval:
   - If it overlaps with the last interval in the merged list, update the ending value.
   - Otherwise, add it as a new interval.
4. Convert the list into a 2D array and return it.

---

## 🧠 Dry Run

### Input

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### After Sorting

```text
[[1,3],[2,6],[8,10],[15,18]]
```

### Process

```text
Merged = [[1,3]]

[2,6] overlaps with [1,3]
Merged = [[1,6]]

[8,10] does not overlap
Merged = [[1,6],[8,10]]

[15,18] does not overlap
Merged = [[1,6],[8,10],[15,18]]
```

### Final Output

```text
[[1,6],[8,10],[15,18]]
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n log n)`

- Sorting takes `O(n log n)`.
- Traversing the intervals takes `O(n)`.

**Space Complexity:** `O(n)`

- Extra space is used to store the merged intervals.

---

## 📚 Concepts Learned

- Sorting 2D Arrays
- Greedy Algorithm
- Interval Merging
- ArrayList
- Comparator in Java

---

## 🎯 Interview Pattern

- Sorting
- Intervals
- Greedy

---

## 🚀 Key Takeaway

Sorting the intervals first makes it easy to identify overlaps. Once sorted, a greedy approach efficiently merges overlapping intervals in a single traversal, making this one of the most common interval patterns in coding interviews.

---

**Language:** Java

**LeetCode:** #56 - Merge Intervals
