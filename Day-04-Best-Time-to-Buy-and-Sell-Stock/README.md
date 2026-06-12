# Day 4 - Best Time to Buy and Sell Stock

## Problem

You are given an array `prices` where `prices[i]` represents the price of a stock on the `i-th` day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve. If no profit can be made, return `0`.

---

## Example

### Input

```java
prices = [7,1,5,3,6,4]
```

### Output

```java
5
```

### Explanation

* Buy at price `1`
* Sell at price `6`

Profit = `6 - 1 = 5`

---

## Approach

Instead of checking every possible buy-sell pair, I used an optimized single-pass approach.

### Steps

1. Keep track of the minimum stock price seen so far.
2. For each day, calculate the profit if the stock were sold on that day.
3. Update the maximum profit whenever a higher profit is found.
4. Return the maximum profit after traversing the array.

This approach ensures that the stock is always bought before it is sold.

---

## Solution

```java
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++) {

            if(prices[i] < minPrice) {
                minPrice = prices[i];
            }

            int currentPrice = prices[i];
            int profit = currentPrice - minPrice;

            if(profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
```

---

## Time Complexity

```text
O(n)
```

The array is traversed only once.

---

## Space Complexity

```text
O(1)
```

Only a few variables are used, regardless of input size.

---

## Concepts Learned

* Arrays
* Greedy Approach
* Single Pass Optimization
* Tracking Minimum Value
* Time Complexity Analysis
* Space Optimization

---

## Language

Java

---

## LeetCode

Problem #121 - Best Time to Buy and Sell Stock
