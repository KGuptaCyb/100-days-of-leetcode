# 301. Remove Invalid Parentheses

**Difficulty:** Hard
**Language:** Java
**Approach:** Breadth-First Search (BFS)

---

## Problem

Given a string `s` containing parentheses and lowercase English letters, remove the **minimum number of invalid parentheses** to make the string valid.

Return **all unique valid strings** that can be obtained using the minimum number of removals.

### Example 1

```text
Input:  s = "()())()"

Output:
["(())()", "()()()"]
```

### Example 2

```text
Input:  s = "(a)())()"

Output:
["(a())()", "(a)()()"]
```

### Example 3

```text
Input:  s = ")("

Output:
[""]
```

---

# Approach

We need to remove the **minimum number of parentheses**.

This makes **BFS** a good choice.

### Why BFS?

Think of every string as a node.

From a string, we generate new strings by removing **one parenthesis**.

```text
Original
   |
   | remove 1 parenthesis
   ↓
Level 1
   |
   | remove 1 parenthesis
   ↓
Level 2
   |
   ↓
...
```

The first level where we find valid strings represents the **minimum number of removals**.

Therefore, once we find valid strings at a particular BFS level, we don't need to explore deeper levels.

---

# Important Idea

We use a `Set` for each BFS level to avoid duplicate strings.

For example:

```text
"(())"
```

Removing different parentheses can sometimes produce the same string.

Using a `Set` automatically removes duplicates.

We also maintain a global `visited` set so that the same string is not processed multiple times.

---

# Valid Parentheses Check

A string is valid when:

1. The number of `(` encountered is never less than the number of `)`.
2. At the end, the counts of `(` and `)` are equal.

We can check this using a `balance` variable.

### Example

```text
s = "(a())"

( → balance = 1
a → balance = 1
( → balance = 2
) → balance = 1
) → balance = 0

Valid
```

If at any point:

```text
balance < 0
```

then there are too many closing parentheses, so the string is invalid.

---

# Algorithm

### Step 1

Create a queue/set containing the original string.

```java
Set<String> current = new HashSet<>();
current.add(s);
```

### Step 2

Check every string in the current BFS level.

If a string is valid, add it to the answer.

### Step 3

If at least one valid string is found:

```text
STOP
```

because this is the minimum-removal level.

### Step 4

Otherwise, generate the next level by removing one parenthesis from every string.

```text
for every string:
    for every character:
        if character is '(' or ')':
            remove it
            add new string
```

### Step 5

Continue until valid strings are found.

---

# Java Solution

```java
import java.util.*;

class Solution {

    public List<String> removeInvalidParentheses(String s) {

        List<String> result = new ArrayList<>();

        Set<String> visited = new HashSet<>();
        Set<String> current = new HashSet<>();

        current.add(s);
        visited.add(s);

        while (!current.isEmpty()) {

            // Check all strings at the current BFS level
            for (String str : current) {
                if (isValid(str)) {
                    result.add(str);
                }
            }

            // If valid strings are found,
            // this is the minimum number of removals.
            if (!result.isEmpty()) {
                return result;
            }

            Set<String> next = new HashSet<>();

            // Generate next level
            for (String str : current) {

                for (int i = 0; i < str.length(); i++) {

                    // We only remove parentheses.
                    if (str.charAt(i) != '(' && str.charAt(i) != ')') {
                        continue;
                    }

                    String nextString =
                            str.substring(0, i) + str.substring(i + 1);

                    // Avoid processing the same string again
                    if (visited.add(nextString)) {
                        next.add(nextString);
                    }
                }
            }

            current = next;
        }

        return result;
    }

    // Checks whether a string has valid parentheses
    private boolean isValid(String s) {

        int balance = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                balance++;
            } 
            else if (c == ')') {
                balance--;
            }

            // More ')' than '('
            if (balance < 0) {
                return false;
            }
        }

        // All '(' must be closed
        return balance == 0;
    }
}
```

---

# Dry Run

Consider:

```text
s = "()())()"
```

### Level 0

```text
()())()
```

Not valid.

So remove one parenthesis from different positions.

---

### Level 1

Possible strings include:

```text
())()
()()()
(())()
...
```

Among them:

```text
()()()
(())()
```

are valid.

Therefore:

```text
Output:
["(())()", "()()()"]
```

We stop here because these solutions required only **one removal**.

---

# Why Don't We Continue?

Suppose we found valid strings after removing one parenthesis.

If we remove two or more parentheses, those solutions cannot be part of the answer because the problem asks for the **minimum number of removals**.

Therefore:

```text
First valid BFS level = Minimum removals
```

---

# Example 2

```text
s = "(a)())()"
```

BFS eventually finds:

```text
"(a())()"
"(a)()()"
```

Both require the same minimum number of removals.

So:

```text
Output:
["(a())()", "(a)()()"]
```

---

# Example 3

```text
s = ")("
```

The original string is invalid.

Removing one parenthesis gives:

```text
")"
"("
```

Neither is valid.

Removing another parenthesis gives:

```text
""
```

The empty string is valid.

Therefore:

```text
Output:
[""]
```

---

# Why Use `visited`?

Without `visited`, the same string can be generated many times.

For example:

```text
"(())"
```

Removing the first `(` or another identical `(` can produce the same result.

The `visited` set ensures that every generated string is processed only once.

```java
if (visited.add(nextString)) {
    next.add(nextString);
}
```

`Set.add()` returns:

* `true` → string was not present
* `false` → string already existed

---

# Why Do We Use `Set` for the Result?

The problem requires:

> unique strings

A `HashSet` naturally handles duplicates.

In this solution, `current` and `visited` are sets, so duplicate strings are already avoided.

The final `result` therefore contains unique valid strings.

---

# Complexity

Let `n` be the length of the string.

There can be exponentially many possible strings because we can remove different subsets of parentheses.

For each generated string:

* Checking validity takes `O(n)`.
* Generating its children can take `O(n)`.
* Creating each substring also takes `O(n)`.

So the worst-case complexity is approximately:

```text
Time:  O(n² × 2^n)
Space: O(n × 2^n)
```

The actual search is smaller in many cases because BFS stops as soon as the first valid level is found.

Given the constraint of at most **20 parentheses**, this approach is suitable.

---

# Key Concepts Learned

* Breadth-First Search
* Level-order processing
* HashSet for duplicate removal
* String manipulation
* Parentheses validation
* Minimum-removal problems
* State-space search

---

# Interview Explanation

If asked to explain the solution:

> "I use BFS because every BFS level represents removing one additional parenthesis. I start with the original string and generate new strings by removing one parenthesis at a time. At every level, I check whether any generated string is valid. The first level containing valid strings guarantees the minimum number of removals. I use a HashSet to avoid duplicate states and a visited set so that the same string is not processed multiple times. Once I find valid strings at a level, I immediately return them because deeper levels would require more removals."

---

# Pattern to Remember

This problem follows the pattern:

```text
Minimum number of removals
            ↓
Generate states by removing 1 element
            ↓
BFS
            ↓
Check validity at each level
            ↓
First valid level = answer
```

### One-line memory trick

**"BFS + remove one parenthesis + stop at first valid level."**
