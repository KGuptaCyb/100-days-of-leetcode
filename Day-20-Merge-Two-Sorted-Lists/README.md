# Day 20 - Merge Two Sorted Lists

## Problem

You are given the heads of two sorted linked lists.

Merge the two lists into one sorted linked list and return the head of the merged list.

The merged list should be made by splicing together the nodes of the first two lists.

---

## Example 1

### Input

```text
List1: 1 -> 2 -> 4
List2: 1 -> 3 -> 4
```

### Output

```text
1 -> 1 -> 2 -> 3 -> 4 -> 4
```

---

## Example 2

### Input

```text
List1: []
List2: []
```

### Output

```text
[]
```

---

## Example 3

### Input

```text
List1: []
List2: 0
```

### Output

```text
0
```

---

## Approach

I solved this problem using the **Dummy Node Technique**.

### Idea

- Create a dummy node to simplify list construction.
- Maintain a `tail` pointer to build the merged list.
- Compare the current nodes of both lists.
- Attach the smaller node to the merged list.
- Move the corresponding list pointer forward.
- Continue until one list becomes empty.
- Attach the remaining nodes from the non-empty list.

---

## Dry Run

### Input

```text
List1: 1 -> 2 -> 4
List2: 1 -> 3 -> 4
```

### Steps

- Compare 1 and 1 → Take 1 (List1)
- Compare 2 and 1 → Take 1 (List2)
- Compare 2 and 3 → Take 2
- Compare 4 and 3 → Take 3
- Compare 4 and 4 → Take 4 (List1)
- List1 ends → Attach remaining node from List2

### Output

```text
1 -> 1 -> 2 -> 3 -> 4 -> 4
```

---

## Time Complexity

```text
O(n + m)
```

where:

- `n` = Number of nodes in List1
- `m` = Number of nodes in List2

Each node is visited exactly once.

---

## Space Complexity

```text
O(1)
```

No extra linked list is created.

---

## Concepts Learned

- Linked Lists
- Dummy Node Technique
- Two Pointer Approach
- Merging Sorted Data
- Pointer Manipulation
- Interview Problem Solving

---

## Key Takeaway

Using a dummy node simplifies linked list operations by avoiding special handling for the head node. This technique is widely used in many linked list interview questions.

---

## Language

Java

---

## LeetCode

Problem #21 - Merge Two Sorted Lists
