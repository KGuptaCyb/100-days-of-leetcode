# 32. Longest Valid Parentheses

## Problem

Given a string containing only `'('` and `')'`, return the length of the **longest valid (well-formed) parentheses substring**.

### Example 1

**Input:**

```text
s = "(()"
```

**Output:**

```text
2
```

**Explanation:**

The longest valid substring is:

```text
()
```

---

### Example 2

**Input:**

```text
s = ")()())"
```

**Output:**

```text
4
```

**Explanation:**

The longest valid substring is:

```text
()()
```

---

### Example 3

**Input:**

```text
s = ""
```

**Output:**

```text
0
```

---

## Approach

We use a **Stack** to keep track of indices.

The main idea is:

* Push the index of every `'('`.
* When we see `')'`, pop from the stack.
* After popping, if the stack is not empty, we can calculate the length of the current valid substring.
* If the stack becomes empty, we store the current index as the new starting boundary.

### Why store indices?

Consider:

```text
s = ")()())"
```

Indices:

```text
0 1 2 3 4 5
) ( ) ( ) )
```

We need indices to calculate the length:

```text
currentIndex - previousBoundary
```

---

## Important Trick

Initially, push:

```java
stack.push(-1);
```

The `-1` acts as a **boundary before the string starts**.

For example:

```text
s = "()"
```

Initially:

```text
stack = [-1]
```

At index `0`:

```text
'(' → push 0
stack = [-1, 0]
```

At index `1`:

```text
')' → pop 0
stack = [-1]
```

Now:

```text
length = 1 - (-1)
       = 2
```

So the answer is `2`.

---

## Step-by-Step Example

For:

```text
s = ")()())"
```

Start:

```text
stack = [-1]
maxLength = 0
```

### Index 0 → `)`

Pop:

```text
stack = []
```

Stack is empty, so update the boundary:

```text
stack.push(0)
```

---

### Index 1 → `(`

Push:

```text
stack = [0, 1]
```

---

### Index 2 → `)`

Pop `1`:

```text
stack = [0]
```

Calculate:

```text
length = 2 - 0 = 2
```

So:

```text
maxLength = 2
```

---

### Index 3 → `(`

Push:

```text
stack = [0, 3]
```

---

### Index 4 → `)`

Pop `3`:

```text
stack = [0]
```

Calculate:

```text
length = 4 - 0 = 4
```

So:

```text
maxLength = 4
```

---

### Index 5 → `)`

Pop `0`:

```text
stack = []
```

Stack is empty, so:

```text
stack.push(5)
```

Final answer:

```text
4
```

---

## Java Solution

```java
class Solution {
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } 
            else {
                stack.pop();

                if (stack.isEmpty()) {
                    stack.push(i);
                } 
                else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
```

---

## How the Algorithm Works

There are two cases.

### Case 1: `'('`

Push its index:

```java
stack.push(i);
```

Because we need to remember where the opening bracket occurred.

### Case 2: `')'`

First pop the matching `'('`:

```java
stack.pop();
```

Then:

**If stack is empty:**

```java
stack.push(i);
```

This means the current `')'` cannot be part of a valid substring, so it becomes the new boundary.

**If stack is not empty:**

```java
maxLength = Math.max(maxLength, i - stack.peek());
```

The index at the top of the stack represents the boundary before the current valid substring.

---

## Why `i - stack.peek()`?

Suppose:

```text
s = "()(())"
```

At some point:

```text
i = 5
stack.peek() = -1
```

Then:

```text
length = 5 - (-1)
       = 6
```

The entire string is valid.

The stack's top tells us the position **just before the current valid substring starts**.

Therefore:

```text
current index - boundary index
```

gives the length.

---

## Complexity

### Time Complexity

```text
O(n)
```

We process every character once.

### Space Complexity

```text
O(n)
```

The stack can contain up to `n` indices.

---

## Key Takeaway

Remember these three steps:

```text
'(' → PUSH index

')' → POP

After POP:
    stack empty     → push current index
    stack not empty → calculate i - stack.peek()
```

And the most important initialization:

```java
stack.push(-1);
```

`-1` acts as the initial boundary and makes length calculation work correctly from the beginning.
