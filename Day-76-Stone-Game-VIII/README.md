Day 76 - Stone Game VIII
Problem

Given an integer array stones, Alice and Bob take turns playing a game, with Alice starting first.

On each turn, while more than one stone remains:

Choose an integer x > 1.
Remove the leftmost x stones.
Add the sum of the removed stones to the player's score.
Place a new stone with that sum on the left side.

The game ends when only one stone remains.

Alice tries to maximize the score difference, while Bob tries to minimize it.

Return the final score difference between Alice and Bob when both play optimally.

Examples
[-1,2,-3,4,-5] → 5
[7,-6,5,10,5,-2,-6] → 13
[-10,-12] → -22
Approach
Calculate the total sum of all stones.
Treat each prefix sum as a possible state of the game.
Start with the total sum as the initial score difference.
Process prefix sums from right to left.
For every prefix, update the best score difference using:
dp = max(dp, prefix - dp)
Since only the previous dp value is required, no DP array is needed.
Algorithm
Calculate the total sum of the array.
Initialize dp with the total sum.
Traverse the array from right to left.
Subtract the current stone to obtain the required prefix sum.
Update:
dp = max(dp, prefix - dp)
Return dp.
Time Complexity

O(n)

Space Complexity

O(1)

Concepts Learned
Prefix sums
Dynamic Programming
Game Theory
Minimax optimization
State transition
Space optimization
Language

Java

LeetCode

Problem #1872 - Stone Game VIII
