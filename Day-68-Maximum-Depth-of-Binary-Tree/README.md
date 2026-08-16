# Day 68 - Maximum Depth of Binary Tree

## 📝 Problem

Given the root of a binary tree, return its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

## 💡 Approach

Used **Depth-First Search (DFS)** with recursion.

For every node:
- If the node is `null`, return `0`.
- Recursively calculate the depth of the left subtree.
- Recursively calculate the depth of the right subtree.
- Return `1 + max(leftDepth, rightDepth)`.

This works because the depth of the current node is one more than the maximum depth of its two subtrees.

## 🔍 Example

Input:
`[3,9,20,null,null,15,7]`

Tree:

```text
        3
       / \
      9   20
         /  \
        15   7
