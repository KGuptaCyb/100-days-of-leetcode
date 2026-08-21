# Day 73 - Subsets

## LeetCode 78 - Medium

### Problem
Given an integer array `nums` containing unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets.

### Example

Input:
nums = [1,2,3]

Output:
[[],[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]]

### Approach

I used **Backtracking** to generate all possible subsets.

For every element, we have two choices:

1. Include the element in the current subset.
2. Skip the element.

After exploring a choice, we remove the element to backtrack and explore the next possibility.

### Algorithm

1. Start with an empty subset.
2. Add the current subset to the result.
3. Iterate through the remaining elements.
4. Add an element to the current subset.
5. Recursively generate further subsets.
6. Remove the element using backtracking.
7. Continue until all possibilities are explored.

### Complexity

- Time Complexity: `O(n × 2^n)`
- Space Complexity: `O(n)` excluding the output

There are `2^n` possible subsets.

### Key Concept

- Backtracking
- Recursion
- Array
- Power Set

### Java

```java
import java.util.*;

class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(0, nums, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int index, int[] nums,
                           List<Integer> current,
                           List<List<Integer>> result) {

        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {

            current.add(nums[i]);

            backtrack(i + 1, nums, current, result);

            current.remove(current.size() - 1);
        }
    }
}
