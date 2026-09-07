# LeetCode 940 - Distinct Subsequences II

## Problem

Given a string `s`, return the number of distinct non-empty subsequences of `s`.

Since the answer can be very large, return it modulo `10^9 + 7`.

---

## Approach

This is a Dynamic Programming problem.

The main challenge is handling duplicate subsequences when the same character appears multiple times.

We use:

- `dp[i]` to represent the number of distinct subsequences, including the empty subsequence, that can be formed using the first `i` characters.
- `last[c]` to store the DP value before the previous occurrence of character `c`.

When adding a new character, every existing subsequence can either:

1. Skip the new character.
2. Add the new character.

Therefore, initially:

`dp[i] = 2 * dp[i - 1]`

However, if the character has appeared before, some subsequences will be duplicated.

We remove those duplicates using:

`dp[i] = 2 * dp[i - 1] - last[c]`

Finally, we subtract `1` to exclude the empty subsequence.

---

## Java Solution

```java
class Solution {
    public int distinctSubseqII(String s) {
        final long MOD = 1000000007;

        long[] dp = new long[s.length() + 1];
        long[] last = new long[26];

        dp[0] = 1;

        for (int i = 1; i <= s.length(); i++) {
            int c = s.charAt(i - 1) - 'a';

            dp[i] = (2 * dp[i - 1] - last[c] + MOD) % MOD;

            last[c] = dp[i - 1];
        }

        return (int) ((dp[s.length()] - 1 + MOD) % MOD);
    }
}
