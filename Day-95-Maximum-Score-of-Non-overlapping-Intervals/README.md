# Day 95 - Maximum Score of Non-overlapping Intervals

## Problem
You are given a list of intervals where each interval is represented as `[left, right, weight]`.

You can select at most 4 non-overlapping intervals.

Two intervals are considered non-overlapping only if the left endpoint of the second interval is strictly greater than the right endpoint of the first interval.

The goal is to maximize the total weight of the selected intervals.

If multiple selections have the same maximum score, return the lexicographically smallest list of their original indices.

```text
intervals = [[1,3,2],[4,5,2],[1,5,5],[6,9,3],[6,7,1],[8,9,1]]
