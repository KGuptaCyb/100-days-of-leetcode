# Day 3 - Running Sum of 1D Array

## Problem
Given an array nums, return the running sum of nums.

A running sum is calculated as:

runningSum[i] = sum(nums[0]...nums[i])

## Example

Input:
[1,2,3,4]

Output:
[1,3,6,10]

## Approach

- Traverse the array from index 1.
- Add the previous element's running sum to the current element.
- Update the array in-place.

## Time Complexity

O(n)

## Space Complexity

O(1)

## Concepts Learned

- Arrays
- Prefix Sum
- Array Traversal
- In-place Modification

## Language

Java

## LeetCode

Problem #1480 - Running Sum of 1D Array
