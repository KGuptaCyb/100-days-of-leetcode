class Solution {
    public String lexPalindromicPermutation(String s, String target) {

        int n = s.length();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        String middle = "";

        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 == 1) {
                if (!middle.isEmpty()) {
                    return "";
                }

                middle = String.valueOf((char) ('a' + i));
                count[i]--;
            }
        }

        int half = n / 2;

        for (int i = 0; i < half; i++) {
            count[target.charAt(i) - 'a'] -= 2;
        }
        boolean possible = true;

        for (int x : count) {
            if (x < 0) {
                possible = false;
                break;
            }
        }

        if (possible) {
            String left = target.substring(0, half);
            String candidate = left + middle + reverse(left);

            if (candidate.compareTo(target) > 0) {
                return candidate;
            }
        }
        for (int i = half - 1; i >= 0; i--) {

            int current = target.charAt(i) - 'a';

            count[current] += 2;
            possible = true;

            for (int x : count) {
                if (x < 0) {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                continue;
            }
            int next = current + 1;

            while (next < 26 && count[next] == 0) {
                next++;
            }

            if (next == 26) {
                continue;
            }

            count[next] -= 2;

            StringBuilder left = new StringBuilder();
            left.append(target, 0, i);
            left.append((char) ('a' + next));
            for (int c = 0; c < 26; c++) {
                int pairs = count[c] / 2;

                while (pairs-- > 0) {
                    left.append((char) ('a' + c));
                }
            }

            String leftPart = left.toString();

            return leftPart + middle + reverse(leftPart);
        }

        return "";
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
