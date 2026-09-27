LeetCode 1190 – Reverse Substrings Between Each Pair of Parentheses
Approach

We can solve this problem using a Stack.

The important observation is that parentheses are nested, so we need to reverse the innermost substring first.

Steps
Create a Stack<StringBuilder>.
Start with an empty StringBuilder.
Traverse the string character by character.
If we see '(':
Save the current string on the stack.
Start a new empty StringBuilder.
If we see a letter:
Add it to the current StringBuilder.
If we see ')':
Reverse the current StringBuilder.
Take the previous string from the stack.
Append the reversed substring to it.
At the end, the StringBuilder contains the answer without parentheses.

This naturally handles nested parentheses because the innermost pair is completed first.

Java Solution
import java.util.*;

class Solution {
    public String reverseParentheses(String s) {

        Stack<StringBuilder> stack = new Stack<>();

        StringBuilder current = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                // Save the current string
                stack.push(current);

                // Start a new substring
                current = new StringBuilder();
            }
            else if (ch == ')') {
                // Reverse the substring inside parentheses
                current.reverse();

                // Get the string before '('
                StringBuilder previous = stack.pop();

                // Append reversed substring
                previous.append(current);

                current = previous;
            }
            else {
                // Add normal character
                current.append(ch);
            }
        }

        return current.toString();
    }
}
Dry Run

Consider:

s = "(u(love)i)"
Step 1

We see:

(

Push the current empty string onto the stack.

Stack: [""]
Current: ""
Step 2

Read:

u
Current: "u"
Step 3

We see another:

(

Push "u" onto the stack.

Stack: ["", "u"]
Current: ""
Step 4

Read:

love
Current: "love"
Step 5

We see:

)

Reverse:

"love" → "evol"

Pop "u" from the stack:

"u" + "evol" = "uevol"

Now:

Stack: [""]
Current: "uevol"
Step 6

Read:

i
Current: "uevoli"
Step 7

Final ):

Reverse:

"uevoli" → "iloveu"

Final answer:

"iloveu"
Another Example
s = "(ed(et(oc))el)"

The innermost substring is:

(oc)

Reverse:

oc → co

Then:

(etco)

Reverse:

etco → octe

Finally:

(edocteel)

Reverse:

leetcode

So the answer is:

leetcode
Why Stack Works

The stack remembers what was present before each opening parenthesis.

For example:

(u(love)i)

When we encounter the inner (, we save:

"u"

Then we process "love" independently.

After reversing "love":

"evol"

we attach it back to "u".

This is exactly what a stack is good at: handling nested structures in Last-In-First-Out order.

Complexity

Let n be the length of the string.

Time Complexity
O(n²)

In the worst case, repeated reversals and string concatenations can take quadratic time.

Space Complexity
O(n)

The stack and StringBuilder objects together require at most O(n) space.

Concepts Learned
Stack
Nested parentheses
StringBuilder
reverse()
LIFO (Last-In-First-Out)
String parsing
Handling nested structures
Key Takeaway

Whenever a problem contains nested structures such as:

(a(b(c)))

a stack is often useful because the innermost structure must be processed before the outer structure.

For this problem:

Opening '(' → save current string
Letters      → build current string
Closing ')'  → reverse and merge
LeetCode
Reverse Substrings Between Each Pair of Parentheses

Language: Java
