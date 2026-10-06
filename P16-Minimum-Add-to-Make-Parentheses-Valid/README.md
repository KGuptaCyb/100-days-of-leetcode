# 921. Minimum Add to Make Parentheses Valid

[LeetCode Problem]

## 🟢 Difficulty

**Medium**

## 🧩 Problem

You are given a string `s` containing only `'('` and `')'`.

A parentheses string is **valid** when:

* Every opening parenthesis `(` has a matching closing parenthesis `)`.
* Parentheses are correctly ordered.

In one move, you can **insert** either `(` or `)` at any position.

Return the **minimum number of insertions** required to make the string valid.

### Example 1

```text
Input: s = "())"

Output: 1
```

We can insert one `(`:

```text
()) → (())
```

The string is now valid.

### Example 2

```text
Input: s = "((("

Output: 3
```

We need three closing parentheses:

```text
((( → ((()))
```

---

# 💡 Approach

We can solve this using a **Greedy** approach.

We maintain two variables:

```text
open = number of unmatched '('
ans  = number of insertions required
```

### Step 1: When we see `(`

An opening parenthesis needs a future `)` to match it.

So:

```text
open++
```

### Step 2: When we see `)`

If we already have an unmatched `(`:

```text
open > 0
```

then this `)` can match it:

```text
open--
```

Otherwise, there is no `(` available to match this `)`.

We must insert an opening parenthesis before it:

```text
ans++
```

### Step 3: After processing the string

If there are still unmatched opening parentheses:

```text
open > 0
```

we need one `)` for each of them.

Therefore:

```text
ans += open
```

---

# 🔍 Example Walkthrough

Consider:

```text
s = "())"
```

Start:

```text
open = 0
ans = 0
```

### Character 1: `(`

```text
open = 1
ans = 0
```

### Character 2: `)`

It matches the previous `(`:

```text
open = 0
ans = 0
```

### Character 3: `)`

There is no unmatched `(`.

So we need to insert one `(`:

```text
open = 0
ans = 1
```

Final:

```text
ans = 1
```

Therefore:

```text
Output = 1
```

---

# 💻 Java Solution

```java
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int ans = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    ans++;
                }
            }
        }

        // Add ')' for remaining unmatched '('
        ans += open;

        return ans;
    }
}
```

---

# 🧠 Why Does This Work?

There are only two possible problems.

### Case 1: Extra `)`

Example:

```text
)))
```

There is no opening parenthesis available to match them.

For every such `)` we need to insert a `(`.

```text
))) 
↑
need (
```

So we increase `ans`.

---

### Case 2: Extra `(`

Example:

```text
(((
```

After processing the string:

```text
open = 3
```

Each unmatched `(` needs one `)`.

Therefore:

```text
ans += open
```

---

# 📊 Dry Run

For:

```text
s = "()))(("
```

| Character | `open` | `ans` | Explanation         |
| --------- | -----: | ----: | ------------------- |
| `(`       |      1 |     0 | Store unmatched `(` |
| `)`       |      0 |     0 | Matches `(`         |
| `)`       |      0 |     1 | Need to insert `(`  |
| `)`       |      0 |     2 | Need to insert `(`  |
| `(`       |      1 |     2 | Store `(`           |
| `(`       |      2 |     2 | Store `(`           |

At the end:

```text
open = 2
ans = 2
```

We need two `)` for the remaining `((`.

Therefore:

```text
answer = 2 + 2 = 4
```

---

# ⏱️ Complexity

### Time Complexity

```text
O(n)
```

We traverse the string once.

### Space Complexity

```text
O(1)
```

Only two integer variables are used.

---

# ⭐ Key Idea to Remember

Think of `open` as:

> **How many `(` are currently waiting for a `)`?**

For every character:

```text
'(' → open++

')' → if open > 0 → open--
      otherwise    → ans++
```

Finally:

```text
ans += open
```

### One-line formula

```text
Answer = unmatched ')' + unmatched '('
```

This greedy method gives the **minimum number of insertions** because every unmatched parenthesis requires exactly one opposite parenthesis to be inserted.
