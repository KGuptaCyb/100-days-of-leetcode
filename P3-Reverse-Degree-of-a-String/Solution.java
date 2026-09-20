class Solution {
    public int reverseDegree(String s) {
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int reversePosition = 'z' - ch + 1;
            int position = i + 1;

            result += reversePosition * position;
        }

        return result;
    }
}
