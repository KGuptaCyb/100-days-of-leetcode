# LeetCode 2897: Apply Operations on Array to Maximize Sum of Squares

**Difficulty:** Hard

**Topics:** Array, Greedy, Bit Manipulation

**Language:** Java

## Problem Statement

Given a 0-indexed integer array `nums` and a positive integer `k`, we can repeatedly choose two distinct indices and update their values using bitwise AND and OR operations.

* `nums[i] = nums[i] & nums[j]`
* `nums[j] = nums[i] | nums[j]`

Both updates use the original values before the operation.

Choose `k` elements from the resulting array to maximize the sum of their squares. Return the answer modulo `1,000,000,007`.

## Approach: Greedy + Bit Manipulation

The main observation is that these operations can redistribute set bits among array elements while preserving the total number of occurrences of each bit.

To maximize the sum of squares, we want to construct the largest possible numbers by combining available set bits.

### Steps

1. Create an array `bitCount` of size 31 to count how many numbers contain each bit.
2. Traverse every number and count its set bits using `(num & (1 << bit)) != 0`.
3. Repeat the following process `k` times:

   * Start with `num = 0`.
   * For every bit position, if its count is greater than zero, set that bit in `num`.
   * Decrease the count of each bit used.
   * Add `num * num` to the result, taking the modulo.
4. Return the final result.

This greedy strategy builds each number using every bit that is still available. Reusing higher-value bits across different constructed numbers maximizes the sum of squares.

## Java Solution

```java
import java.util.List;

class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int MOD = 1_000_000_007;
        int[] bitCount = new int[31];

        for (int num : nums) {
            for (int bit = 0; bit < 31; bit++) {
                if ((num & (1 << bit)) != 0) {
                    bitCount[bit]++;
                }
            }
        }

        long result = 0;

        for (int i = 0; i < k; i++) {
            long num = 0;

            for (int bit = 0; bit < 31; bit++) {
                if (bitCount[bit] > 0) {
                    num |= (1L << bit);
                    bitCount[bit]--;
                }
            }

            result = (result + num * num) % MOD;
        }

        return (int) result;
    }
}
```

## Example Walkthrough

**Input:**

```text
nums = [2, 6, 5, 8]
k = 2
```

The binary representations are:

| Number | Binary |
| -----: | ------ |
|      2 | `0010` |
|      6 | `0110` |
|      5 | `0101` |
|      8 | `1000` |

The bit counts allow us to construct the following numbers:

* First number: `15` (`1111` in binary).
* Second number: `6` (`0110` in binary).

Now calculate the sum of squares:

```text
15² + 6²
= 225 + 36
= 261
```

**Output:**

```text
261
```

## Complexity Analysis

Let `n` be the length of `nums`.

* **Time Complexity:** `O(31 × n + 31 × k)`, simplified to `O(n + k)` because the number of bit positions is fixed.
* **Space Complexity:** `O(31) = O(1)` auxiliary space.

## Key Takeaways

* Bitwise AND (`&`) identifies bits shared by both numbers.
* Bitwise OR (`|`) combines bits present in either number.
* Greedy construction of numbers with available set bits maximizes the sum of squares.
* Use `long` for squaring numbers to avoid integer overflow.
* Apply modulo `1,000,000,007` to keep the result within the required range.

**Challenge:** #DrGViswanathan
