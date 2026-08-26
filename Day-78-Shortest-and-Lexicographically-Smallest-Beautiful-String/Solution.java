class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int right = 0; right < s.length(); right++) {

            if (s.charAt(right) == '1') {
                ones++;
            }

            while (ones > k) {
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }

            if (ones == k) {
                while (left <= right && s.charAt(left) == '0') {
                    left++;
                }

                String curr = s.substring(left, right + 1);

                if (curr.length() < minLen ||
                    (curr.length() == minLen && curr.compareTo(ans) < 0)) {
                    minLen = curr.length();
                    ans = curr;
                }
            }
        }

        return ans;
    }
}
