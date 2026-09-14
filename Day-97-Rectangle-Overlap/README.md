# Day 97 - Rectangle Overlap

## Problem

You are given two axis-aligned rectangles.

Each rectangle is represented as:
[x1, y1, x2, y2]

where:

(x1, y1) is the bottom-left corner.
(x2, y2) is the top-right corner.

The rectangles are parallel to the X-axis and Y-axis.

We need to determine whether the two rectangles overlap with a positive area.

If the rectangles only touch at an edge or corner, they do not count as overlapping.

Return true if they overlap, otherwise return false.

Example 1
Input
rec1 = [0,0,2,2]
rec2 = [1,1,3,3]
Output
true
Explanation

The first rectangle is:

(0,0) -------- (2,2)
   |              |
   |              |
   |              |
   |              |
(0,0) -------- (2,0)

The second rectangle starts at (1,1) and ends at (3,3).

They share a region between:

x = 1 to 2
y = 1 to 2

Therefore, their intersection has a positive area.

So the answer is:

true
Example 2
Input
rec1 = [0,0,1,1]
rec2 = [1,0,2,1]
Output
false
Explanation

The first rectangle ends at:

x = 1

The second rectangle starts at:

x = 1

Therefore, the two rectangles only touch at their vertical edge.

There is no positive-area intersection.

So the answer is:

false
Example 3
Input
rec1 = [0,0,1,1]
rec2 = [2,2,3,3]
Output
false
Explanation

The first rectangle ends at (1,1).

The second rectangle starts at (2,2).

There is a gap between the two rectangles, so they do not overlap.

Therefore:

false
Approach

We can solve this problem by checking whether the rectangles have overlap in both dimensions.

A positive-area overlap requires:

Horizontal overlap
AND
Vertical overlap
Step 1: Check horizontal overlap

The rectangles do not overlap horizontally if:

rec1[2] <= rec2[0]

or:

rec2[2] <= rec1[0]

Here:

rec1[2] = right side of rec1
rec2[0] = left side of rec2

If one rectangle ends exactly where the other begins, they only touch, so we use <=.

Step 2: Check vertical overlap

The rectangles do not overlap vertically if:

rec1[3] <= rec2[1]

or:

rec2[3] <= rec1[1]

Again, equality means that the rectangles only touch at an edge.

Step 3: Return the result

If neither of the non-overlap conditions is true, the rectangles must overlap with positive area.

Therefore, return:

true
Dry Run

Given:

rec1 = [0,0,2,2]
rec2 = [1,1,3,3]
Step 1: Horizontal Overlap

Check:

rec1[2] <= rec2[0]

2 <= 1

This is:

false

Now check:

rec2[2] <= rec1[0]

3 <= 0

This is also:

false

Therefore, the rectangles overlap horizontally.

Step 2: Vertical Overlap

Check:

rec1[3] <= rec2[1]

2 <= 1

This is:

false

Now check:

rec2[3] <= rec1[1]

3 <= 0

This is:

false

Therefore, the rectangles overlap vertically.

Step 3: Final Result

There is both:

Horizontal overlap

and:

Vertical overlap

Therefore:

Output = true
Important Case

Consider:

rec1 = [0,0,1,1]
rec2 = [1,0,2,1]

Here:

rec1[2] = 1
rec2[0] = 1

So:

rec1[2] <= rec2[0]
1 <= 1

This is true.

This means the rectangles only touch at the edge.

Therefore:

Output = false

This is why we use <= instead of <.
