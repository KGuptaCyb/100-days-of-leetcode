# Day 73 - 3Sum

## Problem
Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that:

- `i != j`
- `i != k`
- `j != k`
- `nums[i] + nums[j] + nums[k] == 0`

The solution must not contain duplicate triplets.

## Approach
Used the **Sorting + Two Pointer** technique.

1. Sort the array.
2. Fix one element using a loop.
3. Use two pointers:
   - `left` → next element
   - `right` → last element
4. Move the pointers based on the current sum.
5. Skip duplicate values to avoid duplicate triplets.

## Example

Input:
`[-1,0,1,2,-1,-4]`

Output:
`[[-1,-1,2],[-1,0,1]]`

## Complexity

- Time Complexity: **O(n²)**
- Space Complexity: **O(1)** excluding the output array.

## Key Concepts
- Sorting
- Two Pointers
- Array Traversal
- Duplicate Handling
- 3Sum Pattern
