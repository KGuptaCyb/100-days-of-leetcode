# Day 49 - Min Stack

## 📝 Problem Statement

Design a stack that supports the following operations in O(1) time:

- `push(x)`
- `pop()`
- `top()`
- `getMin()`

---

## 💡 Approach

Use two stacks:

1. `stack` - stores all elements.
2. `minStack` - stores the minimum value at every level.

Whenever an element is pushed, store the minimum of the current element and the previous minimum.

Therefore, the minimum element can always be accessed using:

```java
minStack.peek()
```

---

## 📊 Complexity Analysis

- `push()` → O(1)
- `pop()` → O(1)
- `top()` → O(1)
- `getMin()` → O(1)
- Space Complexity → O(n)

---

## 📚 Concepts Learned

- Stack
- Design Data Structure
- `push()`
- `pop()`
- `peek()`
- Maintaining Minimum
- O(1) Operations

---

## 🎯 Key Takeaway

A normal stack cannot find the minimum in O(1).

Using an additional stack to keep track of the minimum allows `getMin()` to work in constant time.

**Language:** Java

**LeetCode:** #155 - Min Stack
