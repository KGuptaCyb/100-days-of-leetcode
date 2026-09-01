# Day 84 - Minimum Moves to Clean the Classroom

## LeetCode 3568

### Problem
Find the minimum number of moves required to collect all litter in a grid while managing limited energy, obstacles, and reset areas.

### Approach
- Breadth-First Search (BFS)
- Bitmasking to track collected litter
- State tracking using position, litter mask, and remaining energy
- Reset energy when reaching an `R` cell

### Key Concepts
- BFS
- Bitmasking
- State-Space Search
- Grid Traversal
- Queue
- Dynamic State Tracking

### Complexity
- Time: O(m × n × 2^L × energy)
- Space: O(m × n × 2^L × energy)

### Language
Java

### LeetCode
https://leetcode.com/problems/minimum-moves-to-clean-the-classroom/
