# Day 23 - Linked List Cycle

## Problem

Given the `head` of a linked list, determine if the linked list has a cycle.

A cycle exists if some node in the list can be reached again by continuously following the `next` pointer.

Return `true` if there is a cycle; otherwise, return `false`.

---

## Example 1

### Input

```text
3 -> 2 -> 0 -> -4
     ^         |
     |_________|
```

### Output

```text
true
```

---

## Example 2

### Input

```text
1 -> 2
^    |
|____|
```

### Output

```text
true
```

---

## Example 3

### Input

```text
1 -> null
```

### Output

```text
false
```

---

## Approach

I solved this problem using **Floyd's Cycle Detection Algorithm (Fast & Slow Pointer Technique)**.

### Idea

- Initialize two pointers:
  - `slow` moves one node at a time.
  - `fast` moves two nodes at a time.
- If the linked list contains a cycle, both pointers will eventually meet.
- If `fast` reaches `null`, then there is no cycle.

---

## Dry Run

### Input

```text
1 -> 2 -> 3 -> 4
     ^         |
     |_________|
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
fast = 2
```

### Iteration 3

```text
slow = 4
fast = 4
```

Both pointers meet.

Return:

```text
true
```

---

## Time Complexity

```text
O(n)
```

Each node is visited at most once.

---

## Space Complexity

```text
O(1)
```

No extra data structures are used.

---

## Concepts Learned

- Linked Lists
- Fast & Slow Pointer Technique
- Floyd's Cycle Detection Algorithm
- Pointer Traversal
- Cycle Detection
- Interview Pattern

---

## Key Takeaway

The Fast & Slow Pointer technique is an elegant way to detect cycles without using extra memory. It is widely used in linked list interview questions and helps optimize both time and space.

---

## Language

Java

---

## LeetCode

Problem #141 - Linked List Cycle
