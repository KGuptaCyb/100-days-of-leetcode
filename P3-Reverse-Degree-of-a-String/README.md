# LeetCode 3498 - Reverse Degree of a String

## Problem

Given a string `s`, calculate its reverse degree.

For each character:

1. Find its position in the reversed alphabet:
   - `a = 26`
   - `b = 25`
   - ...
   - `z = 1`
2. Multiply this value by the character's position in the string using 1-based indexing.
3. Add all the products together.

Return the reverse degree of the string.

## Example 1

### Input
s = "abc"
Output
148
Explanation
a → 26 × 1 = 26
b → 25 × 2 = 50
c → 24 × 3 = 72

Therefore:

26 + 50 + 72 = 148
Example 2
Input
s = "zaza"
Output
160
Explanation
z → 1 × 1 = 1
a → 26 × 2 = 52
z → 1 × 3 = 3
a → 26 × 4 = 104

Therefore:

1 + 52 + 3 + 104 = 160
Approach

We traverse the string from left to right.

For every character:

Calculate its reverse alphabet position using:
'z' - character + 1
Calculate its 1-based string position using:
index + 1
Multiply both values.
Add the result to the total.
Dry Run

For:

s = "abc"
Character	Reverse Alphabet Position	String Position	Product
a	26	1	26
b	25	2	50
c	24	3	72

Final result:

26 + 50 + 72 = 148


Time Complexity
O(n)

We traverse the string once.

Space Complexity
O(1)

Only a few variables are used.

Concepts Learned
String Traversal
Character Arithmetic
ASCII Character Values
1-based Indexing
Basic Mathematical Calculation
Key Takeaway

Character arithmetic can make simple string problems very efficient.

Instead of creating a separate alphabet mapping, we can directly calculate the reverse alphabet position using:

'z' - ch + 1
Language

Java

LeetCode

Problem Number: 3498
