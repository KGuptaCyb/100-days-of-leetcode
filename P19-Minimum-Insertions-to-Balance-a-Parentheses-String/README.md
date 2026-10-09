# Minimum Insertions to Balance a Parentheses String

**LeetCode:** [1541. Minimum Insertions to Balance a Parentheses String](https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/)  
**Difficulty:** Medium  
**Language:** Java

## Problem

Every opening parenthesis `(` must be matched with **two consecutive closing parentheses** `))`. Return the minimum number of parentheses that must be inserted to make the string balanced.

## Approach: Count the closing parentheses needed

Maintain two variables:

- `insertions`: the number of characters inserted so far.
- `need`: the number of closing parentheses `)` still required to balance the opening parentheses seen so far.

Process each character:

1. If it is `(`, the required number of closing parentheses must be even before adding another opening parenthesis. If `need` is odd, insert one `)` and reduce `need` by one. Then add two to `need` for the new `(`.
2. If it is `)`, reduce `need` by one.
3. If `need` becomes negative, there was no opening parenthesis available for this `)`. Insert an opening `(`, count one insertion, and set `need` to `1` because this new opening parenthesis still needs one more `)`.
4. At the end, insert `need` closing parentheses to finish balancing the string.

## Java Solution

```java
class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int need = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                // A closing pair must contain two consecutive ')'.
                if (need % 2 == 1) {
                    insertions++;
                    need--;
                }
                need += 2;
            } else {
                need--;

                // There is an extra ')' with no matching '('.
                if (need < 0) {
                    insertions++;
                    need = 1;
                }
            }
        }

        return insertions + need;
    }
}
```

## Example dry run

Input: `s = "(()))"`

| Character | Action | `insertions` | `need` |
|---|---|---:|---:|
| `(` | Need two `)` | 0 | 2 |
| `(` | `need` is even; add two | 0 | 4 |
| `)` | One `)` supplied | 0 | 3 |
| `)` | One `)` supplied | 0 | 2 |
| `)` | One `)` supplied | 0 | 1 |

At the end, `need = 1`, so insert one `)`.

**Output:** `1`

## Complexity

- **Time:** `O(n)` — each character is processed once.
- **Space:** `O(1)` — only two integer variables are used.

## Key takeaway

Unlike ordinary parentheses matching, each `(` requires a closing pair `))`. Tracking how many closing parentheses are still needed lets us solve the problem in one pass without a stack.
