# Day 67 - Binary Tree Right Side View

## 🧩 Problem

Given the root of a binary tree, imagine yourself standing on the right side of it.

Return the values of the nodes that are visible from the right side, from top to bottom.

### Example

Input:

        1
       / \
      2   3
       \   \
        5   4

Output:

    [1, 3, 4]

## 💡 Approach

Used **Breadth-First Search (BFS)** with a Queue.

### Steps

1. Add the root node to the queue.
2. Process the tree level by level.
3. Store the size of the current level.
4. Traverse all nodes of that level.
5. Add the last node of each level to the result.
6. Continue until the queue becomes empty.

The last node processed at every level is the node visible from the right side.

## 🔑 Pattern

**Binary Tree → BFS → Level Order Traversal → Last Node of Each Level**

## 💻 Java Solution

```java
class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                TreeNode node = queue.poll();

                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }

        return result;
    }
}
