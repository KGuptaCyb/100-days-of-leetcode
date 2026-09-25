# LeetCode 1096 - Brace Expansion II

## Problem

Given an expression containing lowercase letters, braces `{}`, and commas, return all possible words represented by the expression.

There are two important operations:

### Union

Expressions separated by commas represent a union.
{a,b,c}

produces:

a
b
c
Concatenation

Expressions placed next to each other represent concatenation.

{a,b}{c,d}

produces:

ac
ad
bc
bd

Every word should appear only once, and the final result must be sorted.

Example 1
Input
expression = "{a,b}{c,{d,e}}"
Output
["ac","ad","ae","bc","bd","be"]
Explanation

The first expression:

{a,b}

produces:

a, b

The second expression:

{c,{d,e}}

produces:

c, d, e

Now concatenate every word from the first set with every word from the second set:

a + c = ac
a + d = ad
a + e = ae

b + c = bc
b + d = bd
b + e = be

Therefore:

["ac","ad","ae","bc","bd","be"]
Example 2
Input
expression = "{{a,z},a{b,c},{ab,z}}"
Output
["a","ab","ac","z"]
Explanation

Different parts of the expression can generate the same word.

For example:

a

may be generated more than once.

A HashSet is used to automatically remove duplicates.

Approach

We use recursive parsing.

The expression can be divided into three levels:

Expression
    ↓
Union
    ↓
Term
    ↓
Concatenation
    ↓
Factor
    ↓
Letter or Braced Expression
Step 1: Parse a Factor

A factor can be:

a

or:

{...}

For a letter, return a set containing that single character.

For a braced expression, recursively parse everything inside the braces.

Step 2: Handle Concatenation

For expressions next to each other, we need every possible combination.

For example:

{a,b}{c,d}

First set:

a
b

Second set:

c
d

Take the Cartesian product:

a + c = ac
a + d = ad
b + c = bc
b + d = bd
Step 3: Handle Union

When a comma is encountered:

{a,b,c}

we add all possible words into the same HashSet.

Because a HashSet does not allow duplicates, duplicate words are automatically removed.

Step 4: Sort the Result

After parsing the complete expression:

Collections.sort(answer);

is used to return the words in lexicographical order.

Dry Run

Consider:

expression = "{a,b}{c,{d,e}}"

First part:

{a,b}

gives:

[a,b]

Second part:

{c,{d,e}}

gives:

[c,d,e]

Now perform concatenation:

a + c = ac
a + d = ad
a + e = ae

b + c = bc
b + d = bd
b + e = be

The final set is:

{ac, ad, ae, bc, bd, be}

After sorting:

["ac","ad","ae","bc","bd","be"]
Java Solution
import java.util.*;

class Solution {

    private String expression;
    private int index;

    public List<String> braceExpansionII(String expression) {
        this.expression = expression;
        this.index = 0;

        Set<String> result = parseExpression();

        List<String> answer = new ArrayList<>(result);
        Collections.sort(answer);

        return answer;
    }

    private Set<String> parseExpression() {
        Set<String> result = new HashSet<>();

        while (index < expression.length() &&
               expression.charAt(index) != '}') {

            Set<String> part = parseTerm();

            result.addAll(part);

            if (index < expression.length() &&
                expression.charAt(index) == ',') {
                index++;
            }
        }

        return result;
    }

    private Set<String> parseTerm() {
        Set<String> result = new HashSet<>();
        result.add("");

        while (index < expression.length()) {

            char ch = expression.charAt(index);

            if (ch == '}' || ch == ',') {
                break;
            }

            Set<String> current = parseFactor();

            result = concatenate(result, current);
        }

        return result;
    }

    private Set<String> parseFactor() {

        char ch = expression.charAt(index);

        if (ch >= 'a' && ch <= 'z') {
            index++;

            Set<String> result = new HashSet<>();
            result.add(String.valueOf(ch));

            return result;
        }

        index++;

        Set<String> result = parseExpression();

        index++;

        return result;
    }

    private Set<String> concatenate(
        Set<String> first,
        Set<String> second
    ) {
        Set<String> result = new HashSet<>();

        for (String a : first) {
            for (String b : second) {
                result.add(a + b);
            }
        }

        return result;
    }
}
Time Complexity

Let W be the number of distinct words generated and L be their maximum length.

The parsing and generation depend on the number of generated combinations.

A practical bound is approximately:

O(W × L)

plus the cost of sorting:

O(W log W)

for the generated words.

Because the expression length is at most 60, the important factor is the number of distinct strings generated.

Space Complexity
O(W × L)

because we store the generated words in sets.

Concepts Learned
Recursion
String Parsing
Sets
HashSet
Cartesian Product
Union
Concatenation
Recursive Descent Parsing
Lexicographical Sorting
Key Takeaway

The most important part of this problem is understanding that the grammar has two different operations:

Comma → Union
Adjacent expressions → Concatenation

Once these two operations are handled separately, the problem becomes much easier to implement.

Using a HashSet also automatically removes duplicate words.

Language

Java

LeetCode

Problem Number: 1096

Problem Name: Brace Expansion II
