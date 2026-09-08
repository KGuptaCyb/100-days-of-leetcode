# LeetCode 3870 - Count Commas in Range

## Problem

Given an integer `n`, return the total number of commas used when writing all integers from `1` to `n` using standard number formatting.

A comma is inserted after every three digits from the right.

Numbers with fewer than four digits do not contain commas.

---

## Approach

Since the constraint is:

`1 <= n <= 10^5`

every number can contain at most one comma.

The first number that contains a comma is:

`1000`

Therefore:

- Numbers from `1` to `999` contain `0` commas.
- Every number from `1000` to `n` contains exactly `1` comma.

So when `n >= 1000`:

`answer = n - 999`

If `n < 1000`, the answer is `0`.

---

## Java Solution

```java
class Solution {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }

        return n - 999;
    }
}
