# Day 98 - Maximum Number of Non-overlapping Palindrome Substrings

## Problem

You are given a string `s` and a positive integer `k`.

We need to select the maximum number of substrings such that:

- Every selected substring is a palindrome.
- The length of every substring is at least `k`.
- The selected substrings do not overlap.

Return the maximum number of valid non-overlapping palindrome substrings that can be selected.

---

## Example 1

### Input
s = "abaccdbbd"
k = 3
Output
2
Explanation

We can select:

"aba"

and:

"dbbd"

Both are palindromes.

"aba" has length 3 and "dbbd" has length 4.

Both lengths are at least:

k = 3

They also do not overlap.

Therefore:

Number of palindromes = 2

So the output is:

2
Example 2
Input
s = "adbcda"
k = 2
Output
0
Explanation

We need palindromes of length at least 2.

The string does not contain any palindrome of length 2 or greater.

Therefore, no valid substring can be selected.

So:

Output = 0
Approach

We use Dynamic Programming.

The solution has two main parts:

Step 1: Find all palindromic substrings

Create a 2D array:

palindrome[i][j]

It tells us whether the substring from index i to index j is a palindrome.

A substring is a palindrome when:

s[i] == s[j]

and the characters between them also form a palindrome.

The condition is:

palindrome[i][j] =
    s[i] == s[j]
    AND
    (length <= 2 OR palindrome[i + 1][j - 1])

For example:

s = "aba"

The first and last characters are both a.

The middle substring:

"b"

is already a palindrome.

Therefore:

"aba" is a palindrome
Step 2: Use Dynamic Programming to select palindromes

Create:

dp[i]

where dp[i] represents the maximum number of valid non-overlapping palindromes that can be selected from the first i characters.

For every position i, we have two choices.

Choice 1: Skip the current character

We do not end a palindrome at position i - 1.

Therefore:

dp[i] = dp[i - 1]
Choice 2: Select a palindrome

Suppose a palindrome starts at start and ends at i - 1.

If:

i - start >= k

and:

palindrome[start][i - 1] == true

then we can select it.

The answer becomes:

dp[start] + 1

We take the maximum:

dp[i] = max(dp[i], dp[start] + 1)

Using dp[start] ensures that the previous selected palindromes end before the current palindrome starts.

Therefore, the selected substrings never overlap.

Dry Run

Given:

s = "abaccdbbd"
k = 3

We want palindromes of length at least 3.

Some valid palindromes are:

"aba"
"acca"
"bb"
"dbbd"

However, "bb" has length 2, which is smaller than k = 3, so it cannot be selected.

The important valid palindromes are:

"aba"
"acca"
"dbbd"
Selecting "aba"

"aba" starts at index 0 and ends at index 2.

start = 0
end = 2
length = 3

Since:

length >= k
3 >= 3

we can select it.

The count becomes:

1
Selecting "acca"

"acca" starts at index 2 and ends at index 5.

However, "aba" already uses index 2.

Therefore, "aba" and "acca" overlap.

We cannot select both.

Selecting "dbbd"

"dbbd" starts at index 5 and ends at index 8.

It does not overlap with "aba".

Therefore, we can select:

"aba"
"dbbd"

The selected substrings are:

aba
   dbbd

Their total count is:

2

Therefore:

Output = 2
