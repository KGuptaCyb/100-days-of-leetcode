
# LeetCode 3483 - Unique 3-Digit Even Numbers

## Problem

Given an array of digits, determine the number of distinct three-digit even numbers that can be formed.

Each copy of a digit can only be used once per number, and numbers cannot have leading zeros.

---

## Approach

Since there are only 900 possible three-digit numbers, we can simply check every number from `100` to `999`.

For each number:

1. Check whether it is even.
2. Extract its hundreds, tens, and units digits.
3. Count how many times each digit is required.
4. Compare the required frequencies with the frequencies available in the input array.
5. If all required digits are available, count the number.

Because every number is checked only once, distinct numbers are automatically counted only once.

---

## Java Solution

```java
class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        // Count frequency of each digit
        for (int digit : digits) {
            count[digit]++;
        }

        int answer = 0;

        // Check every 3-digit number
        for (int num = 100; num <= 999; num++) {

            // The number must be even
            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;

            int[] needed = new int[10];

            needed[a]++;
            needed[b]++;
            needed[c]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (needed[d] > count[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}
