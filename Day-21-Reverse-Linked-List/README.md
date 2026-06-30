# Day 21 - Reverse Linked List

## Problem

Given the `head` of a singly linked list, reverse the list and return the reversed linked list.

---

## Example 1

### Input

```text
1 -> 2 -> 3 -> 4 -> 5
```

### Output

```text
5 -> 4 -> 3 -> 2 -> 1
```

---

## Example 2

### Input

```text
1 -> 2
```

### Output

```text
2 -> 1
```

---

## Example 3

### Input

```text
[]
```

### Output

```text
[]
```

---

## Approach

I solved this problem using the **Three Pointer Technique**.

### Idea

- Use three pointers:
  - `prev` → Points to the previous node.
  - `curr` → Points to the current node.
  - `next` → Stores the next node before changing links.
- Reverse the direction of each pointer one by one.
- Continue until the end of the list.
- Return `prev`, which becomes the new head of the reversed list.

---

## Dry Run

### Input

```text
1 -> 2 -> 3 -> null
```

### Initial State

```text
prev = null
curr = 1
```

### Iteration 1

```text
next = 2

1 -> null

prev = 1
curr = 2
```

### Iteration 2

```text
next = 3

2 -> 1 -> null

prev = 2
curr = 3
```

### Iteration 3

```text
next = null

3 -> 2 -> 1 -> null

prev = 3
curr = null
```

### Final Output

```text
3 -> 2 -> 1
```

---

## Time Complexity

```text
O(n)
```

Each node is visited exactly once.

---

## Space Complexity

```text
O(1)
```

Only three pointers are used.

---

## Concepts Learned

- Linked Lists
- Three Pointer Technique
- Pointer Manipulation
- In-place Reversal
- Interview Pattern

---

## Key Takeaway

Before changing a node's pointer, always save the next node. This prevents losing access to the remaining linked list while reversing it.

---

## Language

Java

---

## LeetCode

Problem #206 - Reverse Linked List
