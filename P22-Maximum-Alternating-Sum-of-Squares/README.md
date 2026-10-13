# LeetCode 3727: Maximum Alternating Sum of Squares

**Difficulty:** Medium
**Language:** Java
**Topics:** Array, Sorting, Greedy

## Problem Statement

Given an integer array `nums`, rearrange its elements in any order to maximize the alternating score.

The score is calculated as:

`arr[0]² - arr[1]² + arr[2]² - arr[3]² + ...`

Return the maximum possible alternating score.

## Approach

1. Create a new `long` array to store the square of each element.
2. Sort the squared values in ascending order.
3. Subtract the smallest `n / 2` squared values.
4. Add the remaining squared values to maximize the score.
5. Return the final score.

**Why does this work?**

The positive positions should contain the largest squared values, while the negative positions should contain the smallest squared values. Sorting the squares helps us arrange them optimally.

## Java Solution

```java
import java.util.Arrays;

class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] squares = new long[n];

        for (int i = 0; i < n; i++) {
            squares[i] = (long) nums[i] * nums[i];
        }

        Arrays.sort(squares);

        long sum = 0;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                sum -= squares[i];
            } else {
                sum += squares[i];
            }
        }

        return sum;
    }
}
```

## Example 1

**Input:**

```text
nums = [1, 2, 3]
```

**Squared values after sorting:**

```text
[1, 4, 9]
```

**Calculation:**

```text
-1 + 4 + 9 = 12
```

**Output:**

```text
12
```

## Example 2

**Input:**

```text
nums = [1, -1, 2, -2, 3, -3]
```

**Squared values after sorting:**

```text
[1, 1, 4, 4, 9, 9]
```

**Calculation:**

```text
-1 - 1 - 4 + 4 + 9 + 9 = 16
```

**Output:**

```text
16
```

## Complexity Analysis

* **Time Complexity:** `O(n log n)` — sorting the squared values.
* **Space Complexity:** `O(n)` — storing the squared values in a separate array.

## Key Learnings

* Square each number before sorting because negative and positive numbers can have the same square.
* Use `long` to avoid integer overflow.
* Greedy strategy: assign the largest squared values to positive positions and the smallest squared values to negative positions.
