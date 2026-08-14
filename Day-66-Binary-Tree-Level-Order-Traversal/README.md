# Day 66 - Binary Tree Level Order Traversal

## LeetCode 102 - Binary Tree Level Order Traversal

### Problem
Given the root of a binary tree, return the level order traversal of its nodes' values.

Level order traversal means visiting the nodes level by level from left to right.

### Approach

Used **Breadth-First Search (BFS)** with a Queue.

1. Add the root node to the queue.
2. Process all nodes present at the current level.
3. Store their values in a list.
4. Add their left and right children to the queue.
5. Repeat until the queue becomes empty.

### Complexity

- Time Complexity: O(n)
- Space Complexity: O(n)

### Key Concepts

- Binary Tree
- BFS
- Queue
- Level Order Traversal
