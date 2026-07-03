# Day 24 - Remove Duplicates from Sorted List

## Problem

Given the head of a sorted linked list, delete all duplicates such that each element appears only once.

Return the linked list after removing duplicates.

---

## Example 1

### Input

```text
1 -> 1 -> 2
```

### Output

```text
1 -> 2
```

---

## Example 2

### Input

```text
1 -> 1 -> 2 -> 3 -> 3
```

### Output

```text
1 -> 2 -> 3
```

---

## Approach

Since the linked list is already sorted, duplicate values always appear next to each other.

### Steps

- Traverse the linked list using a single pointer.
- Compare the current node with the next node.
- If both nodes have the same value, remove the duplicate by updating the `next` pointer.
- Otherwise, move to the next node.
- Continue until reaching the end of the list.

---

## Dry Run

### Input

```text
1 -> 1 -> 2 -> 3 -> 3
```

### Steps

- Compare 1 and 1 → Remove duplicate
- Compare 1 and 2 → Move forward
- Compare 2 and 3 → Move forward
- Compare 3 and 3 → Remove duplicate

### Output

```text
1 -> 2 -> 3
```

---

## Time Complexity

```text
O(n)
```

Each node is visited only once.

---

## Space Complexity

```text
O(1)
```

No extra space is used.

---

## Concepts Learned

- Linked Lists
- Pointer Manipulation
- Sorted Linked Lists
- In-place Node Deletion
- Efficient Traversal

---

## Key Takeaway

Since the linked list is sorted, duplicate values appear consecutively. This allows duplicates to be removed efficiently in a single traversal without using any additional data structures.

---

## Language

Java

---

## LeetCode

Problem #83 - Remove Duplicates from Sorted List
