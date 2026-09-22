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
