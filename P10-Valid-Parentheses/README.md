# Day 07 – Valid Parentheses

## Problem

Given a string `s` containing only:

* `(`
* `)`
* `{`
* `}`
* `[`
* `]`

determine whether the string is valid.

A string is valid when:

1. Every opening bracket is closed by the same type of bracket.
2. Brackets are closed in the correct order.
3. Every closing bracket has a corresponding opening bracket.

---

## Examples

### Example 1

**Input:**

```text
s = "()"
```

**Output:**

```text
true
```

### Example 2

**Input:**

```text
s = "()[]{}"
```

**Output:**

```text
true
```

### Example 3

**Input:**

```text
s = "(]"
```

**Output:**

```text
false
```

### Example 4

**Input:**

```text
s = "([])"
```

**Output:**

```text
true
```

### Example 5

**Input:**

```text
s = "([)]"
```

**Output:**

```text
false
```

---

## Approach

The problem can be solved using a **Stack**.

A stack follows **LIFO (Last In, First Out)** order.

### Steps

1. Traverse every character in the string.
2. If the character is an opening bracket:

   * `(`, `{`, `[`
   * push it into the stack.
3. If the character is a closing bracket:

   * Check whether the stack is empty.
   * If it is empty, there is no matching opening bracket → `false`.
   * Otherwise, pop the top element.
4. Check whether the popped opening bracket matches the current closing bracket.
5. If there is a mismatch → `false`.
6. After processing the entire string, the stack must be empty.

   * Empty stack → `true`
   * Non-empty stack → `false`

---

## Example Walkthrough

For:

```text
s = "([])"
```

| Character | Operation         | Stack |
| --------- | ----------------- | ----- |
| `(`       | Push              | `(`   |
| `[`       | Push              | `([`  |
| `]`       | Matches `[` → Pop | `(`   |
| `)`       | Matches `(` → Pop | Empty |

The stack is empty, so the answer is:

```text
true
```

---

## Java Solution

```java
import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();

                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```

---

## Complexity

### Time Complexity

```text
O(n)
```

Each character is processed once.

### Space Complexity

```text
O(n)
```

In the worst case, all characters can be opening brackets and stored in the stack.

---

## Key Concept

**Stack – LIFO**

The most recently opened bracket must be the first one to close.

For example:

```text
([{ }])
  ↑
The latest opening bracket must close first.
```

This makes a stack the natural data structure for this problem.

---

## LeetCode

**Problem:** 20. Valid Parentheses
**Difficulty:** Easy
**Topic:** Stack, String
