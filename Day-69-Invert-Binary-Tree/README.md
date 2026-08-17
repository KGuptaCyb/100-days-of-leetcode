# Day 69 - Invert Binary Tree

## 🧩 Problem

Given the root of a binary tree, invert the tree and return its root.

Inverting a binary tree means swapping the left and right children of every node.

## 💡 Approach

Used **Depth-First Search (DFS)** with recursion.

### Steps

1. Check if the current node is `null`.
2. Swap the left and right children.
3. Recursively invert the left subtree.
4. Recursively invert the right subtree.
5. Return the root.

## 🔍 Example

Input:

        4
       / \
      2   7
     / \ / \
    1  3 6  9

Output:

        4
       / \
      7   2
     / \ / \
    9  6 3  1

## 💻 Java Solution

```java
class Solution {
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}
