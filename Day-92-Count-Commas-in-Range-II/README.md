# LeetCode 3871 - Count Commas in Range II

## Problem

Given an integer `n`, return the total number of commas used when writing all integers from `1` to `n` in standard number formatting.

A comma is inserted after every three digits from the right.

Examples:

- `999` → `0` commas
- `1,000` → `1` comma
- `1,000,000` → `2` commas
- `1,000,000,000` → `3` commas

---

## Approach

Since `n` can be as large as `10^15`, iterating through every number is not possible.

Instead, group numbers based on how many commas they contain.

### Ranges

- `1` to `999` → `0` commas
- `1,000` to `999,999` → `1` comma
- `1,000,000` to `999,999,999` → `2` commas
- `1,000,000,000` to `999,999,999,999` → `3` commas
- `1,000,000,000,000` onward → `4` commas
- `10^15` → `5` commas

For a range starting at `10^(3k)`, every number contains exactly `k` commas.

For each complete range, we calculate:

```text
number of numbers × commas per number
