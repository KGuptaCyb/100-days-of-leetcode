# Day  — Circle and Rectangle Overlapping

## Problem

Given a circle represented by:

* `radius`
* `(xCenter, yCenter)`

and an axis-aligned rectangle represented by:

* `(x1, y1)` → bottom-left corner
* `(x2, y2)` → top-right corner

Return `true` if the circle and rectangle have at least one point in common.

---

## Approach

The easiest way is to find the **closest point inside the rectangle** to the center of the circle.

For the x-coordinate:

```text
closestX = max(x1, min(xCenter, x2))
```

For the y-coordinate:

```text
closestY = max(y1, min(yCenter, y2))
```

This gives the point in the rectangle that is closest to the circle's center.

Then calculate the squared distance between this point and the circle's center:

```text
distance² = (closestX - xCenter)² + (closestY - yCenter)²
```

If:

```text
distance² <= radius²
```

the circle and rectangle overlap.

---

## Java Solution

```java
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {

        // Find the closest point in the rectangle to the circle's center
        int closestX = Math.max(x1, Math.min(xCenter, x2));
        int closestY = Math.max(y1, Math.min(yCenter, y2));

        // Calculate squared distance
        int dx = closestX - xCenter;
        int dy = closestY - yCenter;

        int distanceSquared = dx * dx + dy * dy;

        // Check whether the closest point lies inside the circle
        return distanceSquared <= radius * radius;
    }
}
```

---

## Example

### Input

```text
radius = 1
xCenter = 0
yCenter = 0

x1 = 1
y1 = -1
x2 = 3
y2 = 1
```

The circle's center is:

```text
(0, 0)
```

The closest point of the rectangle is:

```text
(1, 0)
```

Distance squared:

```text
(1 - 0)² + (0 - 0)²
= 1
```

Radius squared:

```text
1² = 1
```

Since:

```text
1 <= 1
```

the answer is:

```text
true
```

---

## Why This Works

There are two cases:

### 1. Circle center is inside the rectangle

The closest point is the circle's center itself.

Therefore:

```text
distance = 0
```

So the circle and rectangle definitely overlap.

### 2. Circle center is outside the rectangle

We find the point on/in the rectangle that is closest to the circle's center.

If that point is within the circle's radius, the shapes overlap.

Otherwise, they do not.

---

## Complexity

* **Time:** `O(1)`
* **Space:** `O(1)`

Only a few arithmetic operations are required.

---

## Key Takeaway

For **circle vs. axis-aligned rectangle** problems:

> Find the closest point of the rectangle to the circle's center, then compare the distance with the radius.

Remember to compare **squared distances** instead of calculating the actual square root.
