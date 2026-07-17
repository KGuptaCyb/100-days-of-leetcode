# Day 38 - Non-overlapping Intervals

## 📝 Problem Statement

Given an array of intervals where `intervals[i] = [starti, endi]`, return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

---

## 📌 Example

### Input

```text
intervals = [[1,2],[2,3],[3,4],[1,3]]
```

### Output

```text
1
```

### Explanation

Remove the interval `[1,3]` and the remaining intervals become non-overlapping.

---

## 💡 Approach

This problem can be solved using a **Greedy Algorithm**.

### Steps

1. Sort all intervals based on their **ending times**.
2. Keep track of the end time of the last selected interval.
3. Traverse through the remaining intervals:
   - If the current interval starts before the previous interval ends, it overlaps, so increment the removal count.
   - Otherwise, update the end time and keep the interval.
4. Return the total number of removed intervals.

The greedy choice is to always keep the interval that finishes earliest, leaving maximum space for future intervals.

---

## 🧠 Dry Run

### Input

```text
[[1,2],[2,3],[3,4],[1,3]]
```

### After Sorting by End Time

```text
[[1,2],[2,3],[1,3],[3,4]]
```

### Process

Keep:

```text
[1,2]
```

Next:

```text
[2,3]
```

No overlap ✅

Next:

```text
[1,3]
```

Overlaps ❌

Remove it.

Next:

```text
[3,4]
```

No overlap ✅

### Final Answer

```text
1
```

---

## 📊 Complexity Analysis

**Time Complexity:** `O(n log n)`

- Sorting the intervals dominates the complexity.

**Space Complexity:** `O(1)`

- No extra space is used apart from variables.

---

## 📚 Concepts Learned

- Greedy Algorithm
- Interval Scheduling
- Sorting with Comparator
- Optimization Problems

---

## 🎯 Interview Pattern

- Greedy
- Intervals
- Sorting

---

## 🚀 Key Takeaway

Sorting intervals by their ending time is the optimal greedy strategy because it leaves the maximum room for future intervals, minimizing the number of removals required.

---

**Language:** Java

**LeetCode:** #435 - Non-overlapping Intervals
