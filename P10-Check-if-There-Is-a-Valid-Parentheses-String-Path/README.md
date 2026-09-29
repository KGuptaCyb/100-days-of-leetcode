LeetCode 2267 – Check if There Is a Valid Parentheses String Path
Problem

You are given an m x n grid containing only '(' and ')'.

You need to determine whether there exists a path from the top-left cell (0, 0) to the bottom-right cell (m - 1, n - 1) such that:

You can only move right or down.
The characters along the path form a valid parentheses string.
A valid parentheses string must never have more ) than ( at any point.
At the end, the number of ( and ) must be equal.
Example 1
Input
grid = [
    ["(", "(", "("],
    [")", "(", ")"],
    ["(", "(", ")"],
    ["(", "(", ")"]
]
Output
true
Explanation

One possible path creates:

()(())

Track the balance:

(  → 1
)  → 0
(  → 1
(  → 2
)  → 1
)  → 0

The balance never becomes negative and finishes at 0.

Therefore, the path forms a valid parentheses string.

Example 2
Input
grid = [
    [")", ")"],
    ["(", "("]
]
Output
false
Explanation

The starting character is ')'.

A valid parentheses string cannot start with a closing parenthesis because its balance would immediately become negative.

Therefore, no valid path exists.

Approach

This problem can be solved using Dynamic Programming.

The main idea is to keep track of the current parentheses balance while moving through the grid.

Balance

For every character:

'(' → balance + 1
')' → balance - 1

For a valid parentheses string:

balance >= 0 at every point
balance == 0 at the end
DP State

We use:

dp[i][j][balance]

where:

dp[i][j][balance] = true

means:

It is possible to reach cell (i, j) with the given parentheses balance.

At every cell, we can arrive from:

(i - 1, j)   → from above
(i, j - 1)   → from left
Important Observations
1. Path Length Must Be Even

Every path from (0,0) to (m-1,n-1) contains:

m + n - 1

cells.

A valid parentheses string always has even length.

Therefore:

if ((m + n - 1) % 2 != 0) {
    return false;
}
2. Starting Cell Must Be '('

If:

grid[0][0] == ')'

the balance immediately becomes -1.

So we can return false.

3. Balance Can Never Become Negative

If the current balance is negative, the path cannot produce a valid parentheses string.

The DP naturally avoids these states.

DP Transition

Suppose the current cell contains:

'('

Then the balance increases by 1.

So if the current balance is b, the previous cell must have had:

b - 1

Therefore:

dp[i][j][b] = dp[i-1][j][b-1]
           || dp[i][j-1][b-1];

If the current cell contains:

')'

the balance decreases by 1.

So to have balance b now, the previous cell must have had:

b + 1

Therefore:

dp[i][j][b] = dp[i-1][j][b+1]
           || dp[i][j-1][b+1];
Java Solution
class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int length = m + n - 1;

        // Valid parentheses string must have even length
        if (length % 2 != 0) {
            return false;
        }

        // A valid string cannot start with ')'
        if (grid[0][0] == ')') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][length + 1];

        // Starting with '(' gives balance 1
        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance <= length; balance++) {

                    if (grid[i][j] == '(') {

                        // Previous balance must be balance - 1
                        if (balance > 0) {

                            if (i > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i - 1][j][balance - 1];
                            }

                            if (j > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i][j - 1][balance - 1];
                            }
                        }

                    } else {

                        // Previous balance must be balance + 1
                        if (balance < length) {

                            if (i > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i - 1][j][balance + 1];
                            }

                            if (j > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i][j - 1][balance + 1];
                            }
                        }
                    }
                }
            }
        }

        // Valid path must end with balance 0
        return dp[m - 1][n - 1][0];
    }
}
Dry Run

For:

grid = [
    ["(", "(", "("],
    [")", "(", ")"],
    ["(", "(", ")"],
    ["(", "(", ")"]
]

Consider the path producing:

()(())

The balance changes as follows:

Character	Balance
(	1
)	0
(	1
(	2
)	1
)	0

At every step:

balance >= 0

At the end:

balance = 0

Therefore:

true
Why Dynamic Programming?

There can be a very large number of possible paths through the grid.

For an m x n grid, checking every possible path individually would be too expensive.

Instead, DP combines paths that reach the same:

cell + balance

state.

For example, if two different paths reach the same cell with balance 2, we don't need to process those paths separately.

We only need to remember:

dp[i][j][2] = true

This avoids exploring every path individually.

Complexity

Let:

m = number of rows
n = number of columns

The maximum possible balance is at most:

m + n - 1
Time Complexity
O(m × n × (m + n))

For every cell, we check all possible balance values.

Space Complexity
O(m × n × (m + n))

for the 3D DP array.

Concepts Learned
Dynamic Programming
3D DP
Grid Path DP
State representation
Parentheses balance
Valid parentheses
DP transitions
Boundary checking
Early optimization
Key Takeaway

This problem combines two ideas:

Grid Path
    +
Parentheses Balance

Instead of tracking the complete string formed by every path, we only track the information that matters:

Current Cell
+
Current Balance

A path is valid only if:

Balance never becomes negative
Balance == 0 at the destination

This turns an exponential path-search problem into a manageable Dynamic Programming solution.

LeetCode
Check if There Is a Valid Parentheses String Path

Language: Java




Sponsored options
Ad
