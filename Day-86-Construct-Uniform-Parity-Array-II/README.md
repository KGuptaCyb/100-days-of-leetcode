# LeetCode 3876 - Construct Uniform Parity Array II

## 🧩 Problem

Given an array `nums1` of distinct integers, construct another array `nums2` such that all elements in `nums2` are either **all odd or all even**.

For every index `i`, we can either:

* Keep `nums1[i]`
* Subtract a smaller `nums1[j]` where `j != i` and the difference is at least `1`

Return `true` if such an array can be constructed, otherwise return `false`.

---

## 💡 Approach

The key is to find the **smallest odd number** in the array.

### Case 1: No odd numbers

If every number is even, we can simply keep all elements unchanged.

➡️ `true`

### Case 2: There is a smallest odd number

Let it be `minOdd`.

To make the final array all odd, every even number smaller than `minOdd` would need to subtract another number.

However, there is no smaller odd number available to make that even number become odd.

Therefore:

* If an even number `< minOdd` exists → `false`
* Otherwise → `true`

---

## 🔑 Key Insight

Only one condition can make the construction impossible:

> **An even number exists that is smaller than the smallest odd number.**

---

## 🧪 Examples

### Example 1

`nums1 = [1,4,7]`

Smallest odd = `1`

No even number is smaller than `1`.

✅ Output: `true`

### Example 2

`nums1 = [2,3]`

Smallest odd = `3`

Even number `2 < 3`.

❌ Output: `false`

### Example 3

`nums1 = [4,6]`

There are no odd numbers.

All elements are already even.

✅ Output: `true`

---

## ⏱️ Complexity

* **Time Complexity:** `O(n)`
* **Space Complexity:** `O(1)`

---

## 📚 What I Learned

* How parity behaves under subtraction.
* How identifying the smallest odd element simplifies the problem.
* How to convert a construction problem into a simple mathematical condition.
* How to avoid unnecessary sorting and achieve an `O(n)` solution.

---

## 🔗 LeetCode

**Problem:** 3876. Construct Uniform Parity Array II

#100DaysOfCode #LeetCode #Java #DSA #Arrays #ProblemSolving
