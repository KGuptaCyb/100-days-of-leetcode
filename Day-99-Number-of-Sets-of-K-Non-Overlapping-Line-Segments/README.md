# Day 99 - Number of Sets of K Non-Overlapping Line Segments

## Problem

You are given `n` points on a 1-D plane.

The points are:
0, 1, 2, ..., n - 1

We need to draw exactly k non-overlapping line segments.

Each segment must cover at least two points, which means its two endpoints must be different.

The segments are allowed to share endpoints.

For example:

(0,1) and (1,3)

are allowed because they only share the endpoint 1.

The goal is to find the total number of possible ways to draw exactly k non-overlapping line segments.

Since the answer can be very large, return it modulo:

10^9 + 7
Example 1
Input
n = 4
k = 2

The points are:

0  1  2  3
Output
5
Explanation

The 5 possible ways are:

{(0,2), (2,3)}
{(0,1), (1,3)}
{(0,1), (2,3)}
{(1,2), (2,3)}
{(0,1), (1,2)}

Notice that segments are allowed to share endpoints.

For example:

(0,1)
(1,3)

share the endpoint 1, so they are valid.

Therefore:

Output = 5
Example 2
Input
n = 3
k = 1

The points are:

0  1  2

With one segment, we can choose:

(0,1)
(0,2)
(1,2)

Therefore:

Output = 3
Example 3
Input
n = 30
k = 7
Output
796297179
Explanation

The total number of possible ways before applying the modulo is:

3796297200

Since the problem requires the answer modulo:

1000000007

we calculate:

3796297200 % 1000000007

which gives:

796297179

Therefore:

Output = 796297179
Approach

We use Dynamic Programming with prefix sums.

Step 1: Define the DP

Let:

dp[j][i]

represent the number of ways to draw exactly j line segments using points from:

0 to i

We want:

dp[k][n - 1]

because we need exactly k segments using all available points.

Step 2: Base Case

When we have zero segments, there is one possible way:

Choose nothing

Therefore:

dp[0][i] = 1

for every i.

Step 3: Add a New Segment

Suppose we want to create the segments-th segment.

We consider every possible right endpoint.

The new segment can start at different previous points.

Instead of checking every possible starting point separately, we maintain a prefix sum.

This allows us to calculate the number of possibilities efficiently.

Step 4: Prefix Sum

We maintain:

prefix

which stores the sum of the previous DP values.

For every point i:

prefix = prefix + dp[segments - 1][i - 1]

Then:

dp[segments][i]

can be updated using the previous result and the prefix sum.

The transition is:

dp[segments][i] =
    dp[segments][i - 1] + prefix

We take modulo 10^9 + 7 after every operation.

Dry Run

Consider:

n = 4
k = 2

Points:

0  1  2  3

We want exactly two segments.

Step 1: One Segment

For one segment, we can choose any two different points.

The possible segments are:

(0,1)
(0,2)
(0,3)
(1,2)
(1,3)
(2,3)

There are:

6

possible single segments.

Step 2: Two Segments

Now we need to select two non-overlapping segments.

The valid combinations are:

(0,1), (1,2)
(0,1), (1,3)
(0,1), (2,3)
(0,2), (2,3)
(1,2), (2,3)

Therefore:

Number of ways = 5
DP Idea

The DP avoids explicitly generating every combination.

For every number of segments, we keep track of how many valid ways can be formed up to each point.

For example:

dp[1][i]

stores the number of ways to create one segment using points up to i.

Then:

dp[2][i]

uses the information from:

dp[1]

to construct solutions containing two segments.

This process continues until we reach:

dp[k][n - 1]
