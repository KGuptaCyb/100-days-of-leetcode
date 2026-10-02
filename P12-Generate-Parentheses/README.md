# 22. Generate Parentheses

## Problem

Given `n` pairs of parentheses, generate all combinations of **well-formed parentheses**.

### Example 1

**Input:**

```text
n = 3
```

**Output:**

```text
["((()))","(()())","(())()","()(())","()()()"]
```

### Example 2

**Input:**

```text
n = 1
```

**Output:**

```text
["()"]
```

---

## Approach

We use **Backtracking** to generate all possible valid combinations.

For every position, we have two choices:

* Add `(` if we still have opening brackets available.
* Add `)` only if the number of closing brackets used is less than the number of opening brackets used.

This ensures that we never create an invalid sequence.

### Rules

Let:

* `open` = number of `(` used
* `close` = number of `)` used

We can:

1. Add `(` when:

```text
open < n
```

2. Add `)` when:

```text
close < open
```

3. When the string length becomes `2 * n`, we have a complete valid combination and add it to the result.

---

## Example for n = 3

The backtracking tree starts with:

```text
(
├── ((
│   ├── (((
│   │   └── ((()))
│   └── (()
│       ├── (()(
│       │   └── (()())
│       └── (())
│           └── (())()
└── ()
    └── ()(
        ├── ()((
        │   └── ()(())
        └── ()()
            └── ()()()
```

Therefore, the valid combinations are:

```text
((()))
(()())
(())()
()(())
()()()
```

---

## Java Solution

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        backtrack(result, new StringBuilder(), 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, StringBuilder current,
                           int open, int close, int n) {

        // Complete valid combination
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add opening bracket
        if (open < n) {
            current.append('(');
            backtrack(result, current, open + 1, close, n);
            current.deleteCharAt(current.length() - 1);
        }

        // Add closing bracket
        if (close < open) {
            current.append(')');
            backtrack(result, current, open, close + 1, n);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
```

---

## Why Does `close < open` Matter?

We cannot add a closing bracket unless there is an unmatched opening bracket.

For example:

```text
")("
```

is invalid because we tried to close before opening.

So we only add `)` when:

```text
close < open
```

Example:

```text
Current = "(( "
open = 2
close = 0
```

We can add `)` because:

```text
0 < 2
```

After adding it:

```text
"(()"
open = 2
close = 1
```

We can still add another `)` because:

```text
1 < 2
```

---

## Why Backtracking?

After exploring one possibility, we remove the last character and try another possibility.

For example:

```text
current = "(("
```

We add:

```text
"((("
```

After exploring it, we remove the last `(`:

```text
"(("
```

Then we can try:

```text
"(()"
```

This process of **choose → explore → undo** is called backtracking.

---

## Complexity

The number of valid combinations is the `n`th **Catalan number**:

```text
C(n) = (2n)! / ((n + 1)! × n!)
```

Since we generate all valid combinations, the time complexity is approximately:

```text
O(C(n) × n)
```

because each generated string has length `2n`.

Space complexity:

```text
O(C(n) × n)
```

for storing the generated combinations, plus `O(n)` recursion depth.

---

## Key Takeaway

The most important conditions to remember are:

```java
if (open < n)
    add '(';

if (close < open)
    add ')';
```

**`open < n`** → We haven't used all opening brackets.

**`close < open`** → We have an unmatched `(`, so we are allowed to add `)`.

This guarantees that every generated string is a **well-formed parentheses sequence**.
