import java.util.*;

class Solution {

    static class State {
        int r, c, mask, energy, moves;

        State(int r, int c, int mask, int energy, int moves) {
            this.r = r;
            this.c = c;
            this.mask = mask;
            this.energy = energy;
            this.moves = moves;
        }
    }

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startR = 0, startC = 0;
        int litterCount = 0;

        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        // Find starting position and assign an index to every litter cell
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (classroom[i].charAt(j) == 'S') {
                    startR = i;
                    startC = j;
                }

                if (classroom[i].charAt(j) == 'L') {
                    litterIndex[i][j] = litterCount++;
                }
            }
        }

        // No litter to collect
        if (litterCount == 0) {
            return 0;
        }

        int allCollected = (1 << litterCount) - 1;

        /*
         * visited[r][c][mask][energy]
         * Since energy <= 50 and litter <= 10,
         * the state space is manageable.
         */
        boolean[][][][] visited =
                new boolean[m][n][1 << litterCount][energy + 1];

        Queue<State> queue = new LinkedList<>();

        int startMask = 0;

        queue.offer(new State(startR, startC, startMask, energy, 0));
        visited[startR][startC][startMask][energy] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            State cur = queue.poll();

            if (cur.mask == allCollected) {
                return cur.moves;
            }

            // Cannot move without energy
            if (cur.energy == 0) {
                continue;
            }

            for (int d = 0; d < 4; d++) {

                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (classroom[nr].charAt(nc) == 'X') {
                    continue;
                }

                int newEnergy = cur.energy - 1;
                int newMask = cur.mask;

                // Collect litter
                if (classroom[nr].charAt(nc) == 'L') {
                    int idx = litterIndex[nr][nc];
                    newMask |= (1 << idx);
                }

                // Reset energy at R
                if (classroom[nr].charAt(nc) == 'R') {
                    newEnergy = energy;
                }

                if (!visited[nr][nc][newMask][newEnergy]) {

                    visited[nr][nc][newMask][newEnergy] = true;

                    queue.offer(
                        new State(
                            nr,
                            nc,
                            newMask,
                            newEnergy,
                            cur.moves + 1
                        )
                    );
                }
            }
        }

        return -1;
    }
}
