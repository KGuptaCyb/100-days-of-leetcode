# Day 25 - Remove Linked List Elements

## Problem

Given the head of a linked list and an integer `val`, remove all the nodes of the linked list that have `Node.val == val`, and return the new head.

---

## Example 1

### Input

```text
head = [1,2,6,3,4,5,6]
val = 6
```

### Output

```text
1 -> 2 -> 3 -> 4 -> 5
```

---

## Example 2

### Input

```text
head = []
val = 1
```

### Output

```text
[]
```

---

## Example 3

### Input

```text
head = [7,7,7,7]
val = 7
```

### Output

```text
[]
```

---

## Approach

I solved this problem using the **Dummy Node Technique**.

### Steps

- Create a dummy node before the head.
- Traverse the linked list using a pointer.
- If the next node contains the target value, remove it by updating the `next` pointer.
- Otherwise, move to the next node.
- Return `dummy.next` as the new head of the linked list.

---

## Dry Run

### Input

```text
1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
```

Target Value

```text
6
```

### Steps

- Visit 1 → Keep
- Visit 2 → Keep
- Visit 6 → Remove
- Visit 3 → Keep
- Visit 4 → Keep
- Visit 5 → Keep
- Visit 6 → Remove

### Output

```text
1 -> 2 -> 3 -> 4 -> 5
```

---

## Time Complexity

```text
O(n)
```

Each node is visited once.

---

## Space Complexity

```text
O(1)
```

Only a few pointers are used.

---

## Concepts Learned

- Linked Lists
- Dummy Node Technique
- Pointer Manipulation
- Node Deletion
- In-place Modification

---

## Key Takeaway

Using a dummy node simplifies linked list problems where the head node itself might need to be removed. This avoids writing separate logic for deleting the first node and makes the solution cleaner.

---

## Language

Java

---

## LeetCode

Problem #203 - Remove Linked List Elements
