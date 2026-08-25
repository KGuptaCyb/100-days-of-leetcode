# Day 77 - Smallest Missing Multiple of K

## Problem

Given an integer array `nums` and an integer `k`, return the **smallest positive multiple** of `k` that is missing from `nums`.

A multiple of `k` is any positive integer divisible by `k`.

### Examples

* `nums = [8,2,3,4,6], k = 2` → `10`
* `nums = [1,4,7,10,15], k = 5` → `5`

## Approach

I solved this problem using a **HashSet and Enumeration** approach.

1. Store all elements of `nums` in a `HashSet`.
2. Start checking from the first positive multiple of `k`, which is `k`.
3. Check multiples in increasing order: `k, 2k, 3k, ...`
4. If a multiple is not present in the set, return it.
5. Since we check multiples from smallest to largest, the first missing multiple is the answer.

## Algorithm

* Create a `HashSet<Integer>`.
* Add every element from `nums` to the set.
* Start with `multiple = k`.
* While the multiple exists in the set:

  * Increase it by `k`.
* Return the first missing multiple.

## Time Complexity

O(n)

## Space Complexity

O(n)

## Concepts Learned

* HashSet
* Hash Table
* Enumeration
* Constant-Time Lookup
* Array Traversal
* Finding Missing Values

## Language

Java

## LeetCode

Problem #3718 - Smallest Missing Multiple of K
