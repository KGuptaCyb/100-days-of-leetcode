LeetCode 1807 – Evaluate the Bracket Pairs of a String
Approach

We can solve this problem using a HashMap.

Steps
Store every key → value pair from knowledge in a HashMap.
Traverse the string from left to right.
If the current character is not '(', add it directly to the result.
If we find '(':
Find the corresponding ')'.
Extract the key between them.
Check whether the key exists in the HashMap.
If it exists, append its value.
Otherwise, append "?".
Continue until the entire string is processed.

Since there are no nested brackets, we can directly search for the closing bracket.

Java Solution
import java.util.*;

class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {

        // Store key-value pairs
        Map<String, String> map = new HashMap<>();

        for (List<String> pair : knowledge) {
            map.put(pair.get(0), pair.get(1));
        }

        StringBuilder result = new StringBuilder();

        int i = 0;

        while (i < s.length()) {

            // Normal character
            if (s.charAt(i) != '(') {
                result.append(s.charAt(i));
                i++;
            } 
            else {
                // Find closing bracket
                int j = i + 1;

                while (s.charAt(j) != ')') {
                    j++;
                }

                // Extract key
                String key = s.substring(i + 1, j);

                // Replace with value or ?
                if (map.containsKey(key)) {
                    result.append(map.get(key));
                } else {
                    result.append("?");
                }

                // Move after ')'
                i = j + 1;
            }
        }

        return result.toString();
    }
}
Dry Run

For:

s = "(name)is(age)yearsold"

knowledge = [
    ["name", "bob"],
    ["age", "two"]
]

First, create the map:

name → bob
age  → two

Now traverse s:

(name)

Key = name

name → bob

Result:

bob

Then:

is

Result:

bobis

Next:

(age)

Key = age

age → two

Result:

bobistwo

Finally:

yearsold

Final result:

bobistwoyearsold
Example with Unknown Key
s = "hi(name)"
knowledge = [["a", "b"]]

Map:

a → b

We encounter:

(name)

But name is not present in the map.

Therefore:

(name) → ?

Final answer:

hi?
Complexity

Let n be the length of s and k be the number of knowledge pairs.

Time Complexity
O(n + k)

Building the HashMap takes O(k) and traversing the string takes O(n).

Space Complexity
O(k)

for storing the key-value pairs in the HashMap.

Concepts Learned
HashMap
String traversal
StringBuilder
substring()
Key-value lookup
Handling unknown keys
Parsing strings using brackets
Key Takeaway

The main idea is to separate the problem into two parts:

knowledge → HashMap
string → scan and replace bracket pairs

Using a HashMap allows us to quickly find the value corresponding to each key.

LeetCode
Evaluate the Bracket Pairs of a String

Language: Java
