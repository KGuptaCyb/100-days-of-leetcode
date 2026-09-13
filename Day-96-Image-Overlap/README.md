# Day 96 - Image Overlap

## Problem

You are given two binary square matrices `img1` and `img2` of size `n x n`.

Each matrix contains only `0` and `1`.

We can translate one image by moving all its `1` bits:

- Left
- Right
- Up
- Down
- Or a combination of these directions

Rotation is not allowed.

After translating one image, we place it over the other image.

The overlap is the number of positions where both images contain `1`.

The goal is to find the maximum possible overlap.

---

## Example

### Input

```text
img1 = [[1,1,0],
        [0,1,0],
        [0,1,0]]

img2 = [[0,0,0],
        [0,1,1],
        [0,0,1]]
