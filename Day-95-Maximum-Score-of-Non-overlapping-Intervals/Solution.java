import java.util.*;

class Solution {

    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] arr = new int[n][4];

        for (int i = 0; i < n; i++) {
            arr[i][0] = intervals.get(i).get(0);
            arr[i][1] = intervals.get(i).get(1);
            arr[i][2] = intervals.get(i).get(2);
            arr[i][3] = i;
        }
        Arrays.sort(arr, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        int[] next = new int[n];

        for (int i = 0; i < n; i++) {
            int low = i + 1;
            int high = n;

            while (low < high) {
                int mid = low + (high - low) / 2;

                if (arr[mid][0] > arr[i][1]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            next[i] = low;
        }
        State[][] dp = new State[n + 1][5];
        for (int k = 0; k <= 4; k++) {
            dp[n][k] = new State(0, new ArrayList<>());
        }
        for (int i = 0; i <= n; i++) {
            dp[i][0] = new State(0, new ArrayList<>());
        }
        for (int i = n - 1; i >= 0; i--) {

            for (int k = 1; k <= 4; k++) {
                State skip = dp[i + 1][k];
                State nextState = dp[next[i]][k - 1];

                long score = arr[i][2] + nextState.score;

                ArrayList<Integer> indices =
                        new ArrayList<>(nextState.indices);

                indices.add(arr[i][3]);
                Collections.sort(indices);

                State take = new State(score, indices);

                dp[i][k] = better(skip, take);
            }
        }

        return dp[0][4].indices
                .stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    private State better(State a, State b) {
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }
        return compare(a.indices, b.indices) <= 0 ? a : b;
    }
    private int compare(List<Integer> a, List<Integer> b) {

        int size = Math.min(a.size(), b.size());

        for (int i = 0; i < size; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }

    static class State {

        long score;
        ArrayList<Integer> indices;

        State(long score, ArrayList<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }
}
