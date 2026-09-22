Yes — the error is because product was declared as long[], but the Node constructor expects an int.

Since every product is stored modulo k and k <= 5, we don't need long at all. We can simply use int[].
Fix

Change:

long[] product;

to:

int[] product;

Then the complete corrected solution is:

class Solution {

    int n, k;
    int[] product;
    int[][] count;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        product = new int[4 * n];
        count = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Apply the update
            update(1, 0, n - 1, index, value);

            // Query [start, n - 1]
            Node result = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            answer[q] = result.count[x];
        }

        return answer;
    }

    // Build segment tree
    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            int value = nums[left] % k;

            product[node] = value;
            count[node][value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        merge(node);
    }

    // Merge two children
    private void merge(int node) {

        int leftChild = node * 2;
        int rightChild = node * 2 + 1;

        product[node] =
            (product[leftChild] * product[rightChild]) % k;

        // Prefixes completely inside the left segment
        for (int r = 0; r < k; r++) {
            count[node][r] = count[leftChild][r];
        }

        // Prefixes that contain all of left
        // and some prefix of right
        for (int r = 0; r < k; r++) {

            int newRemainder =
                (product[leftChild] * r) % k;

            count[node][newRemainder] += count[rightChild][r];
        }
    }

    // Point update
    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            product[node] = value % k;

            for (int r = 0; r < k; r++) {
                count[node][r] = 0;
            }

            count[node][product[node]] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        merge(node);
    }

    // Range query
    private Node query(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {

        if (queryLeft <= left && right <= queryRight) {

            return new Node(
                product[node],
                count[node].clone()
            );
        }

        int mid = left + (right - left) / 2;

        if (queryRight <= mid) {
            return query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );
        }

        if (queryLeft > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );
        }

        Node leftResult = query(
            node * 2,
            left,
            mid,
            queryLeft,
            queryRight
        );

        Node rightResult = query(
            node * 2 + 1,
            mid + 1,
            right,
            queryLeft,
            queryRight
        );

        return combine(leftResult, rightResult);
    }

    // Combine two queried nodes
    private Node combine(Node left, Node right) {

        int newProduct =
            (left.product * right.product) % k;

        int[] newCount = new int[k];

        // Prefixes entirely inside left
        for (int r = 0; r < k; r++) {
            newCount[r] = left.count[r];
        }

        // Prefixes containing all of left
        // and a prefix of right
        for (int r = 0; r < k; r++) {

            int newRemainder =
                (left.product * r) % k;

            newCount[newRemainder] += right.count[r];
        }

        return new Node(newProduct, newCount);
    }

    static class Node {

        int product;
        int[] count;

        Node(int product, int[] count) {
            this.product = product;
            this.count = count;
        }
    }
}

Why int is safe here

Even though nums[i] can be as large as 10^9, we immediately calculate:

nums[i] % k

and:

k <= 5

So product[node] can only be:

0, 1, 2, 3, or 4

The multiplication is also at most:

4 × 4 = 16

before taking % k.

So int is completely sufficient.

The specific error at line 119:

product[node],

was caused by:

long[] product;

being passed to:

Node(int product, int[] count)

Changing long[] → int[] fixes it.

Line 116: error: incompatible types: possible lossy conversion from long to int                 product[node],                        ^
correct this code

You're right — if you're still getting the same error, the code being submitted still has long[] product somewhere.

Here is a clean version with product as int[] everywhere. You can replace the entire code in LeetCode with this; don't keep any part of the previous version.

class Solution {

    int n;
    int k;
    int[] product;
    int[][] count;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        product = new int[4 * n];
        count = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query nums[start ... n-1]
            Node node = query(1, 0, n - 1, start, n - 1);

            result[i] = node.count[x];
        }

        return result;
    }

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            int remainder = nums[left] % k;

            product[node] = remainder;
            count[node][remainder] = 1;

            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        merge(node);
    }

    private void merge(int node) {

        int leftNode = node * 2;
        int rightNode = node * 2 + 1;

        // Product of the complete segment
        product[node] =
            (product[leftNode] * product[rightNode]) % k;

        // Start with prefixes completely inside the left segment
        for (int r = 0; r < k; r++) {
            count[node][r] = count[leftNode][r];
        }

        // Add prefixes that contain all of the left segment
        // and some prefix of the right segment
        for (int r = 0; r < k; r++) {

            int remainder =
                (product[leftNode] * r) % k;

            count[node][remainder] += count[rightNode][r];
        }
    }

    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            product[node] = value % k;

            for (int r = 0; r < k; r++) {
                count[node][r] = 0;
            }

            count[node][product[node]] = 1;

            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        merge(node);
    }

    private Node query(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {

        if (queryLeft <= left && right <= queryRight) {
            return new Node(
                product[node],
                count[node].clone()
            );
        }

        int mid = (left + right) / 2;

        if (queryRight <= mid) {
            return query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );
        }

        if (queryLeft > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );
        }

        Node leftResult = query(
            node * 2,
            left,
            mid,
            queryLeft,
            queryRight
        );

        Node rightResult = query(
            node * 2 + 1,
            mid + 1,
            right,
            queryLeft,
            queryRight
        );

        return combine(leftResult, rightResult);
    }

    private Node combine(Node left, Node right) {

        int newProduct =
            (left.product * right.product) % k;

        int[] newCount = new int[k];

        // Prefixes completely inside left
        for (int r = 0; r < k; r++) {
            newCount[r] = left.count[r];
        }

        // Prefixes containing all of left
        // and a prefix of right
        for (int r = 0; r < k; r++) {

            int remainder =
                (left.product * r) % k;

            newCount[remainder] += right.count[r];
        }

        return new Node(newProduct, newCount);
    }

    static class Node {

        int product;
        int[] count;

        Node(int product, int[] count) {
            this.product = product;
            this.count = count;
        }
    }
}

The important correction

There is now only:

int[] product;

and the constructor is:

Node(int product, int[] count)

So this line:

return new Node(product[node], count[node].clone());

is now int → int, with no long → int conversion.

Also, because k <= 5, storing the product modulo k as int is completely safe.
One more thing

If LeetCode is still showing:

Line 116: possible lossy conversion from long to int

then you are almost certainly submitting an older version of the code. Select everything in the LeetCode editor, delete it, and paste the complete code above.

give readme file for this

README.md

# LeetCode 525 - Find X Value of Array II

## Problem

You are given an array of positive integers `nums`, an integer `k`, and a list of queries.

For every query:

1. Update `nums[index]` to `value`.
2. Remove the prefix `nums[0 ... start - 1]`.
3. Then remove any suffix while keeping the array non-empty.
4. Count how many possible remaining arrays have a product whose remainder modulo `k` is equal to `x`.

The update from each query remains active for all following queries.

Return the answer for every query.

## Example 1

### Input

```text
nums = [1,2,3,4,5]
k = 3
queries = [
    [2,2,0,2],
    [3,3,3,0],
    [0,1,0,1]
]

Output

[2,2,2]

Explanation

For the first query:

nums = [1,2,2,4,5]
start = 0
x = 2

After the prefix is removed, we can remove different suffixes.

The valid remaining arrays with product remainder 2 modulo 3 give the answer 2.
Example 2
Input

nums = [1,2,4,8,16,32]
k = 4
queries = [
    [0,2,0,2],
    [0,2,0,1]
]

Output

[1,0]

Key Observation

After removing the prefix:

nums[0 ... start - 1]

we are left with:

nums[start ... n - 1]

Now, removing a suffix means that the remaining elements must form a prefix of this remaining array.

Therefore, the problem becomes:

Count prefixes of nums[start ... n-1]
whose product % k == x

This is the main observation that makes the problem easier to solve.
Why Segment Tree?

There are up to:

n = 100000
queries = 20000

and every query can update one element.

Checking every possible prefix for every query would be too slow.

We use a Segment Tree to efficiently handle:

    Point updates

    Range queries

    Product modulo k

    Counts of prefix products for every possible remainder

Since:

k <= 5

we only need to store at most 5 remainder states for each segment.
Segment Tree Node

Each node stores two pieces of information.
1. Product

The product of all elements in that segment modulo k.

product = product of all elements % k

2. Count

count[r] represents the number of prefixes of the segment whose product has remainder r modulo k.

For example, if:

k = 3

then we maintain:

count[0]
count[1]
count[2]

Merging Two Nodes

Suppose a segment consists of:

Left + Right

A prefix of the combined segment can be of two types.
Case 1: Prefix is completely inside the Left segment

We simply copy the counts from the Left segment.
Case 2: Prefix contains all of Left and part of Right

Suppose:

Left product % k = P

and a prefix of the Right segment has:

Right prefix product % k = R

Then the combined product is:

(P * R) % k

Therefore:

newCount[(P * R) % k] += rightCount[R]

This allows two Segment Tree nodes to be combined in O(k) time.
Approach

For each query:

    Read index, value, start, and x.

    Update nums[index] to value.

    Query the Segment Tree for the range:

[start, n - 1]

    The returned node contains the number of prefixes for every possible remainder.

    Return:

count[x]

Dry Run

Consider:

nums = [1,2,3,4,5]
k = 3
start = 0

The possible remaining arrays are prefixes of the complete array:

[1]
[1,2]
[1,2,3]
[1,2,3,4]
[1,2,3,4,5]

Their product remainders modulo 3 are:

[1]           -> 1
[1,2]         -> 2
[1,2,3]       -> 0
[1,2,3,4]     -> 0
[1,2,3,4,5]   -> 0

Therefore:

remainder 0 -> 3 prefixes
remainder 1 -> 1 prefix
remainder 2 -> 1 prefix

If:

x = 2

the answer is:

1

Java Solution

class Solution {

    int n;
    int k;
    int[] product;
    int[][] count;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.n = nums.length;
        this.k = k;

        product = new int[4 * n];
        count = new int[4 * n][k];

        build(1, 0, n - 1, nums);

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query nums[start ... n-1]
            Node node = query(
                1,
                0,
                n - 1,
                start,
                n - 1
            );

            result[i] = node.count[x];
        }

        return result;
    }

    private void build(int node, int left, int right, int[] nums) {

        if (left == right) {
            int remainder = nums[left] % k;

            product[node] = remainder;
            count[node][remainder] = 1;

            return;
        }

        int mid = (left + right) / 2;

        build(node * 2, left, mid, nums);
        build(node * 2 + 1, mid + 1, right, nums);

        merge(node);
    }

    private void merge(int node) {

        int leftNode = node * 2;
        int rightNode = node * 2 + 1;

        product[node] =
            (product[leftNode] * product[rightNode]) % k;

        for (int r = 0; r < k; r++) {
            count[node][r] = count[leftNode][r];
        }

        for (int r = 0; r < k; r++) {

            int remainder =
                (product[leftNode] * r) % k;

            count[node][remainder] += count[rightNode][r];
        }
    }

    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            product[node] = value % k;

            for (int r = 0; r < k; r++) {
                count[node][r] = 0;
            }

            count[node][product[node]] = 1;

            return;
        }

        int mid = (left + right) / 2;

        if (index <= mid) {
            update(node * 2, left, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, right, index, value);
        }

        merge(node);
    }

    private Node query(
        int node,
        int left,
        int right,
        int queryLeft,
        int queryRight
    ) {

        if (queryLeft <= left && right <= queryRight) {
            return new Node(
                product[node],
                count[node].clone()
            );
        }

        int mid = (left + right) / 2;

        if (queryRight <= mid) {
            return query(
                node * 2,
                left,
                mid,
                queryLeft,
                queryRight
            );
        }

        if (queryLeft > mid) {
            return query(
                node * 2 + 1,
                mid + 1,
                right,
                queryLeft,
                queryRight
            );
        }

        Node leftResult = query(
            node * 2,
            left,
            mid,
            queryLeft,
            queryRight
        );

        Node rightResult = query(
            node * 2 + 1,
            mid + 1,
            right,
            queryLeft,
            queryRight
        );

        return combine(leftResult, rightResult);
    }

    private Node combine(Node left, Node right) {

        int newProduct =
            (left.product * right.product) % k;

        int[] newCount = new int[k];

        for (int r = 0; r < k; r++) {
            newCount[r] = left.count[r];
        }

        for (int r = 0; r < k; r++) {

            int remainder =
                (left.product * r) % k;

            newCount[remainder] += right.count[r];
        }

        return new Node(newProduct, newCount);
    }

    static class Node {

        int product;
        int[] count;

        Node(int product, int[] count) {
            this.product = product;
            this.count = count;
        }
    }
}

Complexity

Let:

n = nums.length
q = number of queries

Build

O(n * k)

Update

Each point update takes:

O(k log n)

Query

Each range query takes:

O(k log n)

Since k <= 5, this is efficient for the given constraints.
Overall

O(nk + qk log n)

Space Complexity

The Segment Tree stores k remainder counts for each node:

O(nk)

Since k <= 5, this is manageable.
Concepts Learned

    Segment Tree

    Point Updates

    Range Queries

    Modular Arithmetic

    Prefix Products

    State Compression

    Custom Segment Tree Nodes

    Combining Two Segment Tree States

Key Takeaway

The most important observation is:

Removing a suffix
        ↓
Choosing a prefix
        ↓
Count prefix products with a particular remainder

The small constraint:

k <= 5

allows us to store the count for every possible remainder inside each Segment Tree node.

This transforms a potentially expensive query into an efficient range query.
Language

Java
LeetCode

Problem Number: 525

Problem Name: Find X Value of Array II
