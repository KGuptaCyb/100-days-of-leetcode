class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int length = m + n - 1;

        if (length % 2 != 0) {
            return false;
        }


        if (grid[0][0] == ')') {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][length + 1];

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                for (int balance = 0; balance <= length; balance++) {

                    if (grid[i][j] == '(') {
                      
                        if (balance > 0) {

                            if (i > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i - 1][j][balance - 1];
                            }

                            if (j > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i][j - 1][balance - 1];
                            }
                        }

                    } else {
                        if (balance < length) {

                            if (i > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i - 1][j][balance + 1];
                            }

                            if (j > 0) {
                                dp[i][j][balance] =
                                    dp[i][j][balance] ||
                                    dp[i][j - 1][balance + 1];
                            }
                        }
                    }
                }
            }
        }

        // Valid path must end with balance 0
        return dp[m - 1][n - 1][0];
    }
}
