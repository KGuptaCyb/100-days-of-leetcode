# Day 57 - Online Stock Span

## 📌 Problem Statement

Design an algorithm that collects daily stock prices and returns the **stock span** for the current day's price.

The **stock span** is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was **less than or equal to today's price**.

**LeetCode Problem:** 901. Online Stock Span

---

## 🧠 Approach

The optimal solution uses a **Monotonic Stack**.

- Maintain a stack storing pairs of **(price, span)**.
- For every incoming stock price:
  - Initialize the span as `1`.
  - While the top of the stack has a price less than or equal to the current price:
    - Add its span to the current span.
    - Remove it from the stack.
  - Push the current `(price, span)` pair onto the stack.
- Return the computed span.

This avoids checking every previous day's price repeatedly and provides an efficient solution.

---

## ✅ Algorithm

1. Create an empty stack of `(price, span)` pairs.
2. For each new stock price:
   - Set `span = 1`.
   - Pop all elements whose price is less than or equal to the current price.
   - Add their spans to the current span.
   - Push the current `(price, span)` onto the stack.
3. Return the span.

---

## 📊 Example

### Input

```
["StockSpanner","next","next","next","next","next","next","next"]

[[],[100],[80],[60],[70],[60],[75],[85]]
```

### Output

```
[null,1,1,1,2,1,4,6]
```

### Explanation

| Price | Span |
|-------:|-----:|
|100|1|
|80|1|
|60|1|
|70|2|
|60|1|
|75|4|
|85|6|

---

## ⏱️ Complexity Analysis

- **Time Complexity:** O(1) amortized per operation
- **Space Complexity:** O(n)

---

## 📚 Concepts Learned

- Monotonic Stack
- Stack Data Structure
- Amortized Time Complexity
- Efficient Stream Processing
- Object-Oriented Design in Java

---

## 🚀 Key Takeaway

Using a **Monotonic Stack** allows us to efficiently compute stock spans by reusing previously calculated spans instead of traversing all previous prices, reducing the average time per operation to **O(1)**.

---

### 🔖 Tags

`Java` `LeetCode` `Day57` `DSA` `Stack` `Monotonic Stack` `Online Stock Span` `Problem Solving` `Coding Challenge`
