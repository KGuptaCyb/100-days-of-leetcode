# LeetCode 115 - Distinct Subsequences

## Problem

Given two strings `s` and `t`, return the number of distinct subsequences of `s` which are equal to `t`.

A subsequence is formed by deleting some characters from a string without changing the relative order of the remaining characters.

## Approach

This problem can be solved using Dynamic Programming.

Instead of generating every possible subsequence, we keep track of the number of ways to form prefixes of `t` using characters from `s`.

We use a 1D DP array:

`dp[j]` = number of ways to form the first `j` characters of `t`.

Initially:

`dp[0] = 1`

because there is exactly one way to form an empty string: choose nothing.

For every character in `s`, we traverse `t` from right to left.

If:

`s[i] == t[j - 1]`

we have two choices:

1. Skip `s[i]`
2. Use `s[i]` to match `t[j - 1]`

Therefore:

`dp[j] = dp[j] + dp[j - 1]`

If the characters do not match, we simply keep `dp[j]` unchanged.

## Why Traverse Backwards?

We traverse `t` from right to left so that `dp[j - 1]` still contains the value from the previous iteration.

If we traversed from left to right, we could accidentally use the same character of `s` multiple times.

## Java Solution

```java
class Solution {
    public int numDistinct(String s, String t) {
        int n = t.length();

        long[] dp = new long[n + 1];

        // Empty string can always be formed in one way
        dp[0] = 1;

        for (int i = 0; i < s.length(); i++) {

            for (int j = n; j >= 1; j--) {

                if (s.charAt(i) == t.charAt(j - 1)) {
                    dp[j] = dp[j] + dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}
```

## Example

Input:

```text
s = "rabbbit"
t = "rabbit"
```

Output:

```text
3
```

There are 3 different ways to select characters from `s` while maintaining their order to form `rabbit`.

## Another Example

Input:

```text
s = "babgbag"
t = "bag"
```

Output:

```text
5
```

There are 5 distinct subsequences of `s` that form `bag`.

## Key Learning

* Learned how to recognize a subsequence counting problem as Dynamic Programming.
* Understood how to define a DP state based on prefixes.
* Learned the importance of iterating backwards in 1D DP.
* Learned how to optimize a 2D DP solution to use only `O(n)` space.

## Complexity

Time Complexity: `O(m × n)`

Space Complexity: `O(n)`

where `m` is the length of `s` and `n` is the length of `t`.

## LeetCode

Problem: 115. Distinct Subsequences

#100DaysOfCode #LeetCode #Java #DSA #DynamicProgramming #Strings #ProblemSolving
