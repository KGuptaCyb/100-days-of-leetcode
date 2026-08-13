# Day 65 - Kth Smallest Element in a BST

## Problem
Given the root of a Binary Search Tree and an integer `k`, return the kth smallest value in the BST.

## Approach

A Binary Search Tree has the property:

Left subtree < Root < Right subtree

Therefore, inorder traversal visits the nodes in sorted order.

We perform an iterative inorder traversal using a stack and decrement `k` whenever a node is visited.

When `k` becomes 0, the current node is the kth smallest element.

## Algorithm

1. Start from the root.
2. Push all left nodes into the stack.
3. Pop a node and visit it.
4. Decrease `k`.
5. If `k == 0`, return the node value.
6. Move to the right subtree.
7. Repeat until the answer is found.

## Complexity

- Time: O(n) worst case
- Space: O(h)

where `h` is the height of the BST.

## Key Concept

Inorder traversal of a BST produces elements in sorted order.

## Language

Java
