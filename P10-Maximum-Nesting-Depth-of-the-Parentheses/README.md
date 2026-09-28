

LeetCode 1614 – Maximum Nesting Depth of the Parentheses
Approach

We can solve this problem using two variables:

    currentDepth → keeps track of the current number of open parentheses.

    maxDepth → stores the maximum depth reached so far.

Steps

    Traverse the string from left to right.

    When we encounter '(', increase currentDepth.

    Update maxDepth.

    When we encounter ')', decrease currentDepth.

    Return maxDepth.

We don't need a stack because we only need to know how deeply nested the parentheses are, not the actual contents inside them.
Java Solution

class Solution {
    public int maxDepth(String s) {

        int currentDepth = 0;
        int maxDepth = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                currentDepth++;

                maxDepth = Math.max(maxDepth, currentDepth);
            }
            else if (ch == ')') {
                currentDepth--;
            }
        }

        return maxDepth;
    }
}

Dry Run

Consider:

s = "(1+(2*3)+((8)/4))+1"

We only care about the parentheses.
Character	Current Depth	Maximum Depth
(	1	1
(	2	2
)	1	2
(	2	2
(	3	3
)	2	3
)	1	3
)	0	3

Therefore:

Output = 3

The 8 is inside three nested pairs of parentheses.
Example 2

s = "(1)+((2))+(((3)))"

For the third expression:

(((3)))

the depth becomes:

(
((
(((

So:

currentDepth = 3
maxDepth = 3

Final answer:

3

Why We Don't Need a Stack

A stack would work, but it would store more information than necessary.

We only need to know:

How many '(' are currently open?

So we can simply maintain a counter.

'(' → depth++
')' → depth--

Whenever the depth increases, we check whether it is the maximum seen so far.
Complexity
Time Complexity

O(n)

We traverse the string exactly once.
Space Complexity

O(1)

We only use two integer variables.
Concepts Learned

    String traversal

    Parentheses matching

    Counters

    Maximum tracking

    Math.max()

    Optimizing a stack-based idea to constant space

Key Takeaway

For problems involving balanced parentheses, a counter can often replace a stack when we only need the current nesting level.

The core idea is:

'(' → increase depth
')' → decrease depth
track maximum depth

LeetCode

    Maximum Nesting Depth of the Parentheses

Language: Java


