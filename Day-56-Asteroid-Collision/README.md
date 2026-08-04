# Day 56 - Asteroid Collision

## 📝 Problem Statement

We are given an array of asteroids represented by integers.

- Positive values move to the right.
- Negative values move to the left.

When two asteroids moving in opposite directions collide:
- The smaller one explodes.
- If both are the same size, both explode.

Return the state of the asteroids after all collisions.

---

## 💡 Approach

This problem is solved using a **Stack**.

### Algorithm

- Traverse the array.
- Push right-moving asteroids into the stack.
- For a left-moving asteroid:
  - Keep checking the top of the stack.
  - Pop smaller right-moving asteroids.
  - Destroy both if equal.
  - Stop if the current asteroid is destroyed.
- Convert the stack into the final answer.

This efficiently simulates all collisions.

---

## 📊 Complexity Analysis

- **Time Complexity:** `O(n)`
- **Space Complexity:** `O(n)`

---

## 📚 Concepts Learned

- Stack
- Simulation
- Array Traversal
- Collision Handling
- Conditional Logic

---

## 🎯 Key Takeaway

The Stack data structure efficiently handles asteroid collisions by maintaining only the surviving asteroids, ensuring each asteroid is processed at most once.

**Language:** Java

**LeetCode:** #735 - Asteroid Collision
