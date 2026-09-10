# LeetCode 2265 - Count Nodes Equal to Average of Subtree

## Problem

Given the root of a binary tree, return the number of nodes where the value of the node is equal to the average of the values in its subtree.

The average is rounded down to the nearest integer.

---

## Approach

We use a postorder DFS traversal.

For every node, we calculate:

- Sum of all values in its subtree
- Number of nodes in its subtree

Then we calculate:

```text
average = sum / number of nodes
