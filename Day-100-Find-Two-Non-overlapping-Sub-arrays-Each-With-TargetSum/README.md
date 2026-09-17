# Day 100 - Find Two Non-overlapping Sub-arrays Each With Target Sum

## Problem

Given an array `arr` and an integer `target`, find two non-overlapping sub-arrays where each sub-array has a sum equal to `target`.

The goal is to minimize the sum of their lengths.

Return the minimum sum of their lengths, or `-1` if two such sub-arrays cannot be found.

## Example 1

### Input
arr = [3,2,2,4,3]
target = 3
Output
2
Explanation

The two valid sub-arrays are:

[3] and [3]

Both have sum 3 and each has length 1.

Therefore:

1 + 1 = 2
Example 2
Input
arr = [7,3,4,7]
target = 7
Output
2
Explanation

The valid sub-arrays are:

[7]
[3,4]
[7]

The first and third sub-arrays do not overlap.

Their total length is:

1 + 1 = 2
Example 3
Input
arr = [4,3,2,6,2,3,4]
target = 6
Output
-1
Explanation

Only one sub-array has sum 6, so we cannot form two non-overlapping sub-arrays.

Approach

Since all array elements are positive, we can use a Sliding Window.

Maintain a window using left and right.
Add elements to the window until the sum reaches the target.
If the sum becomes greater than the target, move left forward.
Whenever the window sum equals the target, we have found a valid sub-array.
Maintain a best array where best[i] stores the shortest valid sub-array found from index 0 to i.
For the current sub-array starting at left, check best[left - 1].
This guarantees that the previous sub-array does not overlap with the current one.
Update the minimum combined length.
Dry Run

For:

arr = [7,3,4,7]
target = 7

We find:

[7]       → length 1
[3,4]     → length 2
[7]       → length 1

When we reach the final [7], the shortest previous valid sub-array is the first [7].

Therefore:

1 + 1 = 2

Answer:
2

Time Complexity
O(n)

Each element is added and removed from the sliding window at most once.

Space Complexity
O(n)

The best array stores the shortest valid sub-array information.

Concepts Learned
Sliding Window
Dynamic Programming
Arrays
Non-overlapping sub-arrays
Minimum length optimization
State tracking
Key Takeaway

This problem taught me how combining two techniques can make a problem much more efficient.

The Sliding Window finds valid target-sum sub-arrays, while the best array remembers the shortest valid sub-array before the current one.

Together, they allow us to find the minimum total length in O(n) time.

Language

Java

LeetCode

Problem Number: 1477

Problem Name: Find Two Non-overlapping Sub-arrays Each With Target Sum
