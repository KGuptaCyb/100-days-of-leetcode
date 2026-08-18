# Day 70 - House Robber

## 🧩 Problem

You are given an integer array `nums` where `nums[i]`
represents the amount of money present in the ith house.

You cannot rob two adjacent houses.

Return the maximum amount of money you can rob without
alerting the police.

## 💡 Approach

Used **Dynamic Programming** with space optimization.

For every house, we have two choices:

1. **Rob the current house**
   - We cannot rob the previous house.
   - Amount = `previousTwo + current`

2. **Skip the current house**
   - Keep the best amount obtained so far.
   - Amount = `previousOne`

Therefore:

```text
current = max(previousOne, previousTwo + nums[i])
