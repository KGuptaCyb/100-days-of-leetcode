# Day 52 - Sort Colors

## 📝 Problem Statement

Given an array `nums` containing only 0s, 1s, and 2s, sort the array in-place without using the library's sort function.

The solution should use constant extra space and complete the task in one pass.

---

## 💡 Approach

This problem is solved using the **Dutch National Flag Algorithm**.

Three pointers are maintained:

- `low` → Position for the next `0`
- `mid` → Current element being processed
- `high` → Position for the next `2`

### Rules

- If `nums[mid] == 0`
  - Swap with `low`
  - Increment both `low` and `mid`

- If `nums[mid] == 1`
  - Just increment `mid`

- If `nums[mid] == 2`
  - Swap with `high`
  - Decrement `high`
  - Do **not** increment `mid`, as the swapped element still needs to be checked.

This approach sorts the array in a single traversal.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(1)`

---

## 📚 Concepts Learned

- Dutch National Flag Algorithm
- Two Pointers
- In-place Sorting
- One-pass Traversal
- Array Manipulation

---

## 🎯 Key Takeaway

The Dutch National Flag Algorithm efficiently partitions the array into three regions using three pointers, allowing us to sort the colors in a single pass with constant extra space.

**Language:** Java

**LeetCode:** #75 - Sort Colors
