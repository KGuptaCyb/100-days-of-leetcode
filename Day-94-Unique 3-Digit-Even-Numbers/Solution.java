class Solution {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];
        for (int digit : digits) {
            count[digit]++;
        }

        int answer = 0;
        for (int num = 100; num <= 999; num++) {
            if (num % 2 != 0) {
                continue;
            }

            int a = num / 100;
            int b = (num / 10) % 10;
            int c = num % 10;
            int[] needed = new int[10];
            needed[a]++;
            needed[b]++;
            needed[c]++;

            boolean possible = true;

            for (int d = 0; d <= 9; d++) {
                if (needed[d] > count[d]) {
                    possible = false;
                    break;
                }
            }

            if (possible) {
                answer++;
            }
        }

        return answer;
    }
}
