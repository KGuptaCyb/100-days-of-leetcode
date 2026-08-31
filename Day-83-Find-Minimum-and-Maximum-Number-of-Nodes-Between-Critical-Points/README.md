# Day 83 - Find the Minimum and Maximum Number of Nodes Between Critical Points

## LeetCode 2058 - Find the Minimum and Maximum Number of Nodes Between Critical Points

### Problem
Given a linked list, identify all critical points (local maxima or local minima)
and return the minimum and maximum distance between any two critical points.

If there are fewer than two critical points, return `[-1, -1]`.

### Approach
- Traverse the linked list while maintaining the previous, current, and next nodes.
- Check whether the current node is a local maximum or local minimum.
- Store the first and most recent critical point indices.
- Calculate the minimum distance between consecutive critical points.
- Calculate the maximum distance between the first and last critical points.

### Complexity
- Time Complexity: O(n)
- Space Complexity: O(1)

### Key Concepts
Linked List | Traversal | Critical Points | Index Tracking

### LeetCode
https://leetcode.com/problems/find-the-minimum-and-maximum-number-of-nodes-between-critical-points/
