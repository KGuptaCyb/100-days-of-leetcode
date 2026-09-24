# Day - Smallest Index With Digit Sum Equal to Index

## Problem

Given an integer array `nums`, return the **smallest index `i`** such that the sum of the digits of `nums[i]` is equal to `i`.

If no such index exists, return `-1`.

### Example

```text
Input:
nums = [1, 3, 2]

Output:
2
```

Explanation:

```text
nums[2] = 2
Digit sum = 2
Index = 2

Therefore, digit sum == index.
```

---

## Approach

We traverse the array from left to right.

For every index `i`:

1. Get the value `nums[i]`.
2. Calculate the sum of its digits.
3. Compare the digit sum with the current index.
4. If they are equal, return `i`.
5. If no index satisfies the condition, return `-1`.

Because we check indices from smallest to largest, the first valid index is automatically the smallest one.

---

## Java Code

```java
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;

            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }

            if (sum == i) {
                return i;
            }
        }

        return -1;
    }
}
```

---

## Dry Run

For:

```text
nums = [1, 10, 11]
```

### Index 0

```text
nums[0] = 1
Digit sum = 1
Index = 0

1 != 0
```

Continue.

### Index 1

```text
nums[1] = 10

10 % 10 = 0
10 / 10 = 1

1 % 10 = 1
1 / 10 = 0

Digit sum = 0 + 1 = 1
Index = 1
```

```text
1 == 1
```

Return:

```text
1
```

---

## Complexity

* **Time Complexity:** `O(n × d)`

  * `n` = number of elements
  * `d` = number of digits in each number

* **Space Complexity:** `O(1)`

---

## Key Concept

### Finding the sum of digits

For a number `num`:

```java
sum += num % 10;
num /= 10;
```

For example, for `123`:

```text
123 % 10 = 3
123 / 10 = 12

12 % 10 = 2
12 / 10 = 1

1 % 10 = 1
1 / 10 = 0

Digit sum = 3 + 2 + 1 = 6
```

The solution then simply checks:

```text
digit sum == index
```

and returns the first matching index.
