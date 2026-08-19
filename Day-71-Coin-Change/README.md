# Day 71 - Coin Change

## 🧩 Problem

Given an integer array `coins` representing different
coin denominations and an integer `amount`, return the
fewest number of coins required to make up the amount.

If the amount cannot be formed, return `-1`.

## 💡 Approach

Used **Dynamic Programming**.

Define:

dp[i] = minimum number of coins required to make amount i

For every amount, try using each available coin.

The state transition is:

dp[i] = min(dp[i], dp[i - coin] + 1)

The base case is:

dp[0] = 0

because zero coins are required to make amount 0.

## 🔍 Example

Input:

coins = [1, 2, 5]
amount = 11

Optimal combination:

5 + 5 + 1 = 11

Output:

3

## 💻 Java Solution

```java
class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // Initialize with an impossible large value
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
        }

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {

            for (int coin : coins) {

                if (coin <= i) {
                    dp[i] = Math.min(
                        dp[i],
                        dp[i - coin] + 1
                    );
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
