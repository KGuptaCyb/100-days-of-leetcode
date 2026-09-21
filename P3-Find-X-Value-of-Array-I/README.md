# LeetCode 3524 - Find X Value of Array I

## Problem

Given an array of positive integers `nums` and an integer `k`, we can remove a prefix and a suffix while keeping the array non-empty.

We need to count how many possible remaining subarrays have a product whose remainder modulo `k` is `0, 1, ..., k-1`.

Return an array `result` where:

```text
result[x] = number of remaining subarrays
           whose product % k == x
```

## Key Observation

Removing a prefix and a suffix always leaves **one non-empty contiguous subarray**.

Therefore, the problem is equivalent to:

> Count all non-empty subarrays according to their product modulo `k`.

Since `k <= 5`, we only need to keep track of `k` possible remainders.

## Approach

Use Dynamic Programming.

Let:

```text
dp[r]
```

represent the number of subarrays ending at the previous index whose product has remainder `r` when divided by `k`.

For every number `num`:

### 1. Start a new subarray

The subarray containing only `num` has:

```text
num % k
```

as its remainder.

### 2. Extend previous subarrays

If a previous subarray has product remainder `r`, after adding `num`:

```text
newRemainder = (r * (num % k)) % k
```

Add its count to the corresponding remainder.

### 3. Add the new counts to the answer

Every subarray ending at the current index represents one valid way of choosing the remaining array.

## Example

```text
nums = [1, 2, 3]
k = 3
```

All non-empty subarrays are:

```text
[1]       -> 1 % 3 = 1
[2]       -> 2 % 3 = 2
[3]       -> 0
[1,2]     -> 2 % 3 = 2
[2,3]     -> 6 % 3 = 0
[1,2,3]   -> 6 % 3 = 0
```

Therefore:

```text
result = [3, 1, 2]
```

## Complexity

Let `n = nums.length`.

### Time Complexity

```text
O(n * k)
```

Since `k <= 5`, this is effectively linear in the size of the array.

### Space Complexity

```text
O(k)
```

We only store counts for the `k` possible remainders.

## Important Learning

The main trick is recognizing that:

```text
remove prefix + remove suffix
```

is equivalent to choosing:

```text
one non-empty contiguous subarray
```

Then we use DP to track **product modulo k**, rather than the actual product.

This avoids dealing with potentially enormous products.
