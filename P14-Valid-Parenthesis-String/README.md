# 678. Valid Parenthesis String

## Problem

Given a string containing three types of characters:

'('
')'
'*'


Return `true` if the string is valid.

The `'*'` character can be treated as:

* `'('`
* `')'`
* `""` (empty)

### Example 1

**Input:**
s = "()"


**Output:**
true

### Example 2

**Input:**
s = "(*)"


**Output:**
true


Here `*` can be treated as an empty string:

(*)
 ↓
()

### Example 3

**Input:**
s = "(*))"


**Output:**

true


Here `*` can be treated as `'('`:


(*))
 ↓
(())


### Example 4

**Input:**

s = "("


**Output:**
false


There is no `')'` or `'*'` available to close the opening parenthesis.

---

# Approach

The difficult part is deciding what `'*'` should represent.

Instead of deciding immediately, we keep track of a **range of possible open parentheses**.

We maintain:

minOpen
maxOpen


### `minOpen`

The **minimum possible number** of unmatched `'('`.

### `maxOpen`

The **maximum possible number** of unmatched `'('`.

For every character:

### If character is `'('`

It must increase the number of open parentheses:
minOpen++
maxOpen++


### If character is `')'`

It closes an opening parenthesis:
minOpen--
maxOpen--


### If character is `'*'`

It can be:

'('  → increase
')'  → decrease
''   → stay the same


Therefore:
minOpen--
maxOpen++

---
# Why Do We Use a Range?

Consider:
s = "(*"


After processing `'('`:

minOpen = 1
maxOpen = 1

Now we see `'*'`.

`'*'` could be:

'('  → open = 2
')'  → open = 0
''   → open = 1

So instead of checking every possibility individually, we store:

minOpen = 0
maxOpen = 2


This represents all possible states between `0` and `2`.

That's the main greedy idea.

---

# Important Conditions

## 1. `maxOpen < 0`

If:

maxOpen < 0


then even the **most optimistic interpretation** has too many closing parentheses.

Therefore, the string can never be valid.

Return:

```java
false
```

For example:
s = ")"

Initially:
minOpen = 0
maxOpen = 0


After `')'`:
minOpen = -1
maxOpen = -1


Since:
maxOpen < 0

the answer is immediately:

false
---

## 2. `minOpen` cannot go below 0

Sometimes `minOpen` becomes negative because `'*'` could act as a `')'`.

But we cannot have fewer than zero unmatched opening parentheses.

So:

```java
minOpen = Math.max(0, minOpen);
```

---

# Step-by-Step Example

Consider:

s = "(*))"


Initially:

```text
minOpen = 0
maxOpen = 0
```

### Character 1: `'('`

```text
minOpen = 1
maxOpen = 1
```

### Character 2: `'*'`

`*` can be `'('`, `')'`, or empty.

Therefore:

```text
minOpen = max(0, 1 - 1) = 0
maxOpen = 1 + 1 = 2
```

So:

```text
possible open parentheses = 0 to 2
```

### Character 3: `')'`

```text
minOpen = 0 - 1 = -1
maxOpen = 2 - 1 = 1
```

Fix the minimum:

```text
minOpen = max(0, -1)
        = 0
```

Now:

```text
minOpen = 0
maxOpen = 1
```

### Character 4: `')'`

```text
minOpen = 0 - 1 = -1
maxOpen = 1 - 1 = 0
```

Again:

```text
minOpen = 0
maxOpen = 0
```

At the end:

```text
maxOpen >= 0
```

and:

```text
minOpen == 0
```

Therefore:

```text
true
```

One valid interpretation is:

```text
(*))
 ↓
(())
```

---

# Java Solution

```java
class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                minOpen++;
                maxOpen++;
            }
            else if (c == ')') {
                minOpen--;
                maxOpen--;
            }
            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // Even the maximum possible opens became negative
            if (maxOpen < 0) {
                return false;
            }

            // Minimum cannot be less than zero
            minOpen = Math.max(0, minOpen);
        }

        // There must be a possibility of having zero unmatched '('
        return minOpen == 0;
    }
}
```

---

# Why `minOpen == 0` at the End?

At the end, we need all opening parentheses to be closed.

Suppose:

```text
s = "((("
```

At the end:

```text
minOpen = 3
maxOpen = 3
```

There are still unmatched opening parentheses.

Therefore:

```text
false
```

But consider:

```text
s = "(*"
```

At the end:

```text
minOpen = 0
maxOpen = 2
```

This is valid because we can choose:

```text
* = ')'
```

giving:

```text
()
```

Since `minOpen == 0`, there is **at least one valid interpretation**.

Therefore:

```text
true
```

---

# Why This Works

The range:

```text
[minOpen, maxOpen]
```

represents the possible number of unmatched opening parentheses after processing the current characters.

For example:

```text
minOpen = 1
maxOpen = 3
```

means the current string can have:

```text
1, 2, or 3
```

unmatched `'('`, depending on how we interpret `'*'`.

We don't need to try every possibility separately.

---

# Complexity

### Time Complexity

```text
O(n)
```

We process each character once.

### Space Complexity

```text
O(1)
```

We only use two integer variables.

---

# Key Takeaway

Remember the two variables:

```text
minOpen → minimum possible '('
maxOpen → maximum possible '('
```

For each character:

```text
'(' → min++, max++

')' → min--, max--

'*' → min--, max++
```

Then:

```text
if (maxOpen < 0)
    return false;
```

because even the most optimistic case is invalid.

And:

```text
minOpen = Math.max(0, minOpen);
```

because the number of unmatched opening brackets cannot be negative.

Finally:

```text
return minOpen == 0;
```

### One-line memory trick

> **`*` gives us flexibility: it can decrease, increase, or leave the number of open brackets unchanged.**

So instead of tracking one exact count, we track a **range of possible counts**.
