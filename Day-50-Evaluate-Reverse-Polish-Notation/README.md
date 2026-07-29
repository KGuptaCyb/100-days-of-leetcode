# Day 50 - Evaluate Reverse Polish Notation

## 📝 Problem Statement

Given an array of strings representing an arithmetic expression in Reverse Polish Notation, evaluate the expression.

The valid operators are:

```text
+  -  *  /
```

---

## 💡 Approach

Use a Stack.

- If the token is a number, push it onto the stack.
- If the token is an operator, pop the top two numbers.
- Perform the operation.
- Push the result back onto the stack.

For subtraction and division, order is important:

```text
b = stack.pop();
a = stack.pop();

a - b
a / b
```
---

## 📊 Complexity Analysis

- Time Complexity: `O(n)`
- Space Complexity: `O(n)`

---

## 📚 Concepts Learned

- Stack
- Reverse Polish Notation
- Expression Evaluation
- `push()` and `pop()`
- String Parsing
- Integer Conversion

---

## 🎯 Key Takeaway

Reverse Polish Notation can be evaluated naturally using a Stack.

Numbers are pushed onto the stack, and whenever an operator appears, the required operands are popped and the result is pushed back.

**Language:** Java

**LeetCode:** #150 - Evaluate Reverse Polish Notation
