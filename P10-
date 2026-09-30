LeetCode 1111 – Maximum Nesting Depth of Two Valid Parentheses Strings
Problem

You are given a valid parentheses string seq.

You need to split its characters into two subsequences:

A
B

such that both A and B are valid parentheses strings.

The goal is to minimize:

max(depth(A), depth(B))

We return an array where:

0 → character belongs to A
1 → character belongs to B
Approach

The key idea is to divide the parentheses based on their current nesting depth.

We maintain:

depth = current nesting depth

When we encounter:

'('

we increase the depth first.

When we encounter:

')'

we use the current depth and then decrease it.

We assign each parenthesis to one of the two groups based on whether the current depth is even or odd.

even depth → group 0
odd depth  → group 1

This distributes the nested parentheses between the two groups.

Why does this work?

Suppose the original string has nesting depth:

6

Instead of putting all six levels into one subsequence, we divide the levels:

Group 0 → depths 1, 3, 5
Group 1 → depths 2, 4, 6

Therefore, each subsequence has a maximum depth of approximately half the original depth.

This gives the minimum possible maximum depth.

Dry Run

Consider:

seq = "(()())"

We track the depth:

Character	Depth	Group
(	1	1
(	2	0
)	2	0
(	2	0
)	2	0
)	1	1

Therefore, one valid answer is:

[1, 0, 0, 0, 0, 1]

This is also a valid answer even though the example gives a different assignment.

The problem allows multiple valid answers.

Understanding the Split

For:

seq = "((()))"

The nesting depths are:

(
(( 
(((

The levels are:

1
2
3

We distribute them as:

Depth 1 → Group 1
Depth 2 → Group 0
Depth 3 → Group 1

So the nesting is divided between the two subsequences instead of putting all three levels into one.

This reduces the maximum nesting depth of either subsequence.

Why Alternating Depth Works

Suppose the original maximum depth is D.

By assigning alternating depth levels:

1, 3, 5, ... → one group
2, 4, 6, ... → other group

each group gets roughly half of the nesting levels.

Therefore:

max(depth(A), depth(B)) = ceil(D / 2)

This is the smallest possible maximum depth because two subsequences must collectively represent all D nesting levels.

Complexity
Time Complexity
O(n)

We traverse the string once.

Space Complexity
O(n)

We store the answer array.

The algorithm itself uses only O(1) extra space apart from the output array.

Concepts Learned
Valid parentheses
Nesting depth
Greedy approach
Parity / odd-even levels
Subsequence
Depth tracking
Optimal partitioning
O(n) string traversal
Key Takeaway

The important observation is that we don't need to explicitly construct the two subsequences.

We only need to track the current nesting depth and alternate the assignment:

Odd depth  → Group 1
Even depth → Group 0

This distributes nested parentheses across the two groups and minimizes the maximum nesting depth.

LeetCode
Maximum Nesting Depth of Two Valid Parentheses Strings

Language: Java
