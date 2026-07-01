# Day 22 - Middle of the Linked List

## Problem

Given the head of a singly linked list, return the middle node of the linked list.

If there are two middle nodes, return the second middle node.

---

## Example 1

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
```

### Output

```text
3 -> 4 -> 5
```

---

## Example 2

### Input

```text
1 -> 2 -> 3 -> 4 -> 5 -> 6
```

### Output

```text
4 -> 5 -> 6
```

---

## Approach

I solved this problem using the **Fast and Slow Pointer** technique.

### Idea

- Initialize two pointers:
  - `slow` moves one step at a time.
  - `fast` moves two steps at a time.
- Continue moving both pointers until `fast` reaches the end.
- At that point, `slow` will be pointing to the middle node.
- If the list has an even number of nodes, `slow` naturally points to the second middle node.

---

## Dry Run

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
```

### Initial State

```text
slow = 1
fast = 1
```

### Iteration 1

```text
slow = 2
fast = 3
```

### Iteration 2

```text
slow = 3
fast = 5
```

The loop ends because `fast.next` becomes `null`.

### Output

```text
3 -> 4 -> 5
```

---

## Time Complexity

```text
O(n)
```

The linked list is traversed only once.

---

## Space Complexity

```text
O(1)
```

Only two pointers are used.

---

## Concepts Learned

- Linked Lists
- Fast & Slow Pointer Technique
- Single Pass Traversal
- Efficient Pointer Manipulation
- Interview Pattern

---

## Key Takeaway

The Fast & Slow Pointer technique is one of the most important patterns for solving linked list problems efficiently. It is also used in problems like Linked List Cycle, Palindrome Linked List, and Happy Number.

---

## Language

Java

---

## LeetCode

Problem #876 - Middle of the Linked List
