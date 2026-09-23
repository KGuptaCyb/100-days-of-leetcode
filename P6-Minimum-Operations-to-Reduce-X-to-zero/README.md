# 658. Minimum Operations to Reduce X to Zero

**LeetCode:** [658. Minimum Operations to Reduce X to Zero](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/)
**Difficulty:** Medium
**Language:** Java

## Problem

Given an integer array `nums` and an integer `x`, in one operation we can remove either the leftmost or rightmost element and subtract its value from `x`.

Return the minimum number of operations needed to reduce `x` to exactly `0`.

If it is impossible, return `-1`.

### Example

```text
Input:
nums = [1,1,4,2,3]
x = 5

Output:
2
```

We can remove `2` and `3` from the right:

```text
5 - 3 - 2 = 0
```

So the answer is `2`.

---

## Approach

Instead of directly finding the elements to remove, we find the elements that should **remain** in the array.

Let:

```text
total = sum of all elements
```

If the removed elements have sum `x`, then the remaining elements must have:

```text
remaining sum = total - x
```

To minimize the number of removed elements, we need to keep the **longest contiguous subarray** whose sum is:

```text
total - x
```

Since all array elements are positive, we can find this longest subarray using a **sliding window**.

Finally:

```text
minimum operations = nums.length - longest subarray length
```

---

## Algorithm

1. Calculate the total sum of the array.
2. Calculate:

   ```text
   target = total - x
   ```
3. If `target < 0`, return `-1`.
4. If `target == 0`, all elements must be removed, so return `nums.length`.
5. Use a sliding window:

   * Expand the window by moving `right`.
   * If the sum becomes greater than `target`, move `left` forward.
   * Whenever the window sum equals `target`, update the maximum window length.
6. If no valid subarray exists, return `-1`.
7. Otherwise return:

   ```text
   nums.length - maxLength
   ```

---

## Java Code

```java
class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        int target = total - x;

        if (target < 0) {
            return -1;
        }

        if (target == 0) {
            return nums.length;
        }

        int left = 0;
        int sum = 0;
        int maxLength = -1;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum > target && left <= right) {
                sum -= nums[left];
                left++;
            }

            if (sum == target) {
                maxLength = Math.max(
                    maxLength,
                    right - left + 1
                );
            }
        }

        if (maxLength == -1) {
            return -1;
        }

        return nums.length - maxLength;
    }
}
```

---

## Example Walkthrough

```text
nums = [1,1,4,2,3]
x = 5
```

Total:

```text
1 + 1 + 4 + 2 + 3 = 11
```

Target:

```text
11 - 5 = 6
```

We need the longest subarray with sum `6`.

```text
[1,1,4] = 6
```

Length:

```text
3
```

Array length:

```text
5
```

Therefore:

```text
5 - 3 = 2
```

Answer:

```text
2
```

---

## Why Sliding Window?

All elements are positive:

```text
nums[i] >= 1
```

Therefore:

* Expanding the window increases the sum.
* Shrinking the window decreases the sum.
* Both pointers only move forward.

This allows us to solve the problem in linear time.

---

## Complexity

### Time Complexity

```text
O(n)
```

Each element is added to and removed from the sliding window at most once.

### Space Complexity

```text
O(1)
```

Only a few variables are used.

---

## Key Takeaway

Instead of asking:

> Which elements should I remove from the left and right?

Think:

> Which longest middle subarray should I keep?

The transformation is:

```text
Remove sum = x

Total sum - Remaining sum = x

Remaining sum = Total sum - x
```

Then find the **longest subarray with sum `total - x`** using sliding window.
