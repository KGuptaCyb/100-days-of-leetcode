# Day 2 - Palindrome Number

## Problem

Given an integer x, return true if x is a palindrome, and false otherwise.

A palindrome number reads the same forward and backward.

### Examples

* 121 → true
* 1221 → true
* 123 → false
* -121 → false

## Approach

1. Store the original number.
2. Reverse the number using modulus (%) and division (/).
3. Compare the reversed number with the original number.
4. If both are equal, the number is a palindrome.

## Algorithm

* Extract the last digit using `x % 10`.
* Append it to the reversed number.
* Remove the last digit using `x / 10`.
* Continue until all digits are processed.

## Time Complexity

O(log n)

## Space Complexity

O(1)

## Concepts Learned

* Modulus operator (%)
* Integer division (/)
* While loops
* Number reversal
* Palindrome checking

## Language

Java

## LeetCode

Problem #9 - Palindrome Number
