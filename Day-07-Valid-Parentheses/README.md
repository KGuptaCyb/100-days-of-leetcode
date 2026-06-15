# Day 7 - Valid Parentheses

## Problem

Given a string `s` containing just the characters:

`()`, `{}`, and `[]`

Determine if the input string is valid.

A string is valid if:

1. Open brackets are closed by the same type of brackets.
2. Open brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

---

## Example 1

### Input

```java
s = "()"
```

### Output

```java
true
```

---

## Example 2

### Input

```java
s = "()[]{}"
```

### Output

```java
true
```

---

## Example 3

### Input

```java
s = "(]"
```

### Output

```java
false
```

---

## Approach

I used a Stack to keep track of opening brackets.

### Steps

1. Traverse the string character by character.
2. Push opening brackets `(`, `{`, `[` into the stack.
3. When a closing bracket is encountered:
   - Check if the stack is empty.
   - Compare the closing bracket with the top element of the stack.
   - If they don't match, return `false`.
   - Otherwise, remove the opening bracket using `pop()`.
4. At the end, if the stack is empty, the string is valid.

---

## Dry Run

Input:

```java
s = "([{}])"
```

### Stack Operations

```text
(  → push
[  → push
{  → push
}  → pop
]  → pop
)  → pop
```

Final Stack:

```text
Empty
```

Output:

```java
true
```

---

## Time Complexity

O(n)

Each character is processed exactly once.

---

## Space Complexity

O(n)

In the worst case, all opening brackets are stored in the stack.

---

## Concepts Learned

- Stack Data Structure
- push()
- pop()
- peek()
- isEmpty()
- String Traversal
- Bracket Matching
- Nested Structures

---

## Key Takeaway

Stacks are extremely useful for solving problems involving matching pairs, nested structures, and expression validation.

---

## Language

Java

---

## LeetCode

Problem #20 - Valid Parentheses
