# Day 51 - Implement Queue using Stacks

## 📝 Problem

Implement a queue using only two stacks.

## 💡 Approach

Maintain two stacks:

- Input stack → stores new elements.
- Output stack → provides queue order.

Whenever output stack becomes empty, transfer all elements from input to output.

This ensures FIFO behavior.

## 📊 Complexity

- Push → O(1)
- Pop → Amortized O(1)
- Peek → Amortized O(1)
- Empty → O(1)

## 📚 Concepts Learned

- Stack
- Queue
- Design Problems
- FIFO
- Amortized Analysis

## 🎯 Key Takeaway

Two stacks can efficiently simulate a queue while maintaining FIFO order.

**Language:** Java

**LeetCode:** #232 - Implement Queue using Stacks
