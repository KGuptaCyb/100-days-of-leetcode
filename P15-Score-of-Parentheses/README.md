
# 856. Score of Parentheses

## Problem

Given a balanced parentheses string `s`, return the **score** of the string.

The score follows these rules:

* `"()"` has a score of `1`.
* `AB` has a score of `A + B`, where `A` and `B` are balanced parentheses strings.
* `(A)` has a score of `2 * A`.

### Examples

**Example 1**

```text
Input: s = "()"
Output: 1
```

**Example 2**

```text
Input: s = "(())"
Output: 2
```

**Example 3**

```text
Input: s = "()()"
Output: 2
```

---

## Approach

We can solve this problem using a **Stack**.

The stack stores the score of each currently open pair of parentheses.

Initially, we push `0` to represent the outermost level.

### For `'('`

When we encounter an opening parenthesis:

```java
stack.push(0);
```

We start a new level with score `0`.

### For `')'`

When we encounter a closing parenthesis:

1. Remove the score inside the current pair.
2. If the inner score is `0`, the pair is `"()"`, so its score is `1`.
3. Otherwise, the pair is `(A)`, so its score is `2 * A`.
4. Add this score to the previous level.

The formula is:

```text
score = inner == 0 ? 1 : 2 * inner
```

---

## Dry Run

For:

```text
s = "(())"
```

| Character | Stack       | Explanation   |
| --------- | ----------- | ------------- |
| Start     | `[0]`       | Initial score |
| `(`       | `[0, 0]`    | New level     |
| `(`       | `[0, 0, 0]` | New level     |
| `)`       | `[0, 0, 1]` | `()` → `1`    |
| `)`       | `[0, 2]`    | `(1)` → `2`   |
| End       | `[2]`       | Final answer  |

Therefore:

```text
Output = 2
```

---

## Java Solution

```java
import java.util.Stack;

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                stack.push(0);

            } else {
                int inner = stack.pop();

                int score;
                if (inner == 0) {
                    score = 1;
                } else {
                    score = 2 * inner;
                }

                int outer = stack.pop();
                stack.push(outer + score);
            }
        }

        return stack.pop();
    }
}
```

---

## Complexity

Let `n` be the length of the string.

### Time Complexity

```text
O(n)
```

We traverse the string once.

### Space Complexity

```text
O(n)
```

In the worst case, the stack can contain `n/2` nested parentheses.

---

## Key Learning

The important observation is:

```text
()   → 1
(A)  → 2 × A
AB   → A + B
```

A stack is useful because every closing parenthesis tells us to finish the score of the **most recently opened level**.

### Pattern to Remember

For nested parentheses problems:

```text
'(' → create a new level
')' → calculate current level and merge it with the previous level
```

This is a useful **Stack pattern** for parentheses and nested-expression problems.
