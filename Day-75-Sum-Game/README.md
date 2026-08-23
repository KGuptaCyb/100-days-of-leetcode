# Day 75 – Sum Game

## LeetCode 1927 – Sum Game

### Problem

Alice and Bob take turns replacing `?` characters in an even-length
string with digits from `0` to `9`.

Alice wins if the sum of the digits in the first half is different
from the sum of the digits in the second half.

Bob wins if both sums are equal.

Both players play optimally.

### Approach

Used a mathematical Game Theory approach.

First, calculate:

- Sum of known digits in the left half
- Sum of known digits in the right half
- Number of `?` characters in the left half
- Number of `?` characters in the right half

Let:

```text
diff = leftSum - rightSum
qDiff = leftQ - rightQ
