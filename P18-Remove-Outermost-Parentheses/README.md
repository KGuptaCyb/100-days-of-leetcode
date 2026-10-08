# 1021. Remove Outermost Parentheses

**Difficulty:** Easy
**Language:** Java
**Approach:** Balance / Counter

---

## Problem

Given a valid parentheses string `s`, remove the **outermost parentheses** from every primitive parentheses string.

### Example 1

```text
Input:  "(()())(())"
Output: "()()()"
```

The primitive decomposition is:

```text
"(()())" + "(())"
```

After removing the outermost parentheses:

```text
"()()" + "()"
```

Therefore:

```text
"()()()"
```

---

## Approach

We use a `balance` variable to track the current depth of parentheses.

### Rules

* When we encounter `'('`:

  * If `balance > 0`, it is **not** an outermost parenthesis, so add it.
  * Then increase `balance`.

* When we encounter `')'`:

  * First decrease `balance`.
  * If `balance > 0`, it is **not** an outermost parenthesis, so add it.

The outermost `'('` is detected when:

```text
balance == 0
```

before increasing the balance.

The outermost `')'` is detected when the balance becomes:

```text
balance == 0
```

after decreasing it.

---

## Algorithm

1. Initialize `balance = 0`.
2. Create a `StringBuilder`.
3. Traverse the string character by character.
4. For `'('`:

   * If `balance > 0`, append it.
   * Increment `balance`.
5. For `')'`:

   * Decrement `balance`.
   * If `balance > 0`, append it.
6. Return the resulting string.

---

## Java Solution

```java
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int balance = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (balance > 0) {
                    result.append(c);
                }
                balance++;
            } else {
                balance--;

                if (balance > 0) {
                    result.append(c);
                }
            }
        }

        return result.toString();
    }
}
```

---

## Dry Run

For:

```text
s = "(()())"
```

| Character | Balance Before | Action    | Balance After |
| --------- | -------------: | --------- | ------------: |
| `(`       |              0 | Don't add |             1 |
| `(`       |              1 | Add `(`   |             2 |
| `)`       |              2 | Add `)`   |             1 |
| `(`       |              1 | Add `(`   |             2 |
| `)`       |              2 | Add `)`   |             1 |
| `)`       |              1 | Don't add |             0 |

Result:

```text
"()()"
```

The first `(` and last `)` are the outermost parentheses, so they are removed.

---

## Example 2

```text
Input:
"(()())(())(()(()))"
```

Primitive strings:

```text
"(()())"
"(())"
"(()(()))"
```

After removing their outermost parentheses:

```text
"()()"
"()"
"()(())"
```

Final result:

```text
"()()()()(())"
```

---

## Example 3

```text
Input:
"()()"
```

Primitive decomposition:

```text
"()" + "()"
```

Removing the outermost parentheses:

```text
"" + ""
```

Output:

```text
""
```

---

## Complexity

Let `n` be the length of the string.

### Time Complexity

```text
O(n)
```

We traverse the string exactly once.

### Space Complexity

```text
O(n)
```

The `StringBuilder` stores the resulting string.

---

## Key Idea

The most important observation is:

```text
balance == 0
```

means we are at the **outermost level** of a primitive.

Therefore:

```text
'(' when balance == 0 → remove
')' when balance becomes 0 → remove
```

Everything inside that primitive is kept.

---

## Interview Explanation

> I use a balance counter to track the nesting depth. For every opening parenthesis, I add it only if the current balance is greater than zero, because a balance of zero means it is the outermost opening parenthesis. For every closing parenthesis, I decrease the balance first and add it only if the balance is still greater than zero. This removes the first and last parenthesis of every primitive substring in one pass.

---

## Pattern to Remember

```text
Opening '('
    ↓
balance == 0 ?
    ↓
Yes → outermost → skip
No  → keep

Closing ')'
    ↓
decrease balance
    ↓
balance == 0 ?
    ↓
Yes → outermost → skip
No  → keep
```

### One-line memory trick

**"Keep parentheses only when the balance is inside a primitive, not at its outer boundary."**
