class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();

        int[] shiftCount = new int[n];

        for (int[] shift : shifts) {
            int start = shift[0];
            int end = shift[1];
            int direction = shift[2];

            if (direction == 1) {
                shiftCount[start]++;
                if (end + 1 < n) {
                    shiftCount[end + 1]--;
                }
            } else {
                shiftCount[start]--;
                if (end + 1 < n) {
                    shiftCount[end + 1]++;
                }
            }
        }

        StringBuilder result = new StringBuilder(s);
        int numberOfShifts = 0;

        for (int i = 0; i < n; i++) {
            numberOfShifts = (numberOfShifts + shiftCount[i]) % 26;
            if (numberOfShifts < 0) numberOfShifts += 26;

            char shifted = (char) ('a' + (s.charAt(i) - 'a' + numberOfShifts) % 26);
            result.setCharAt(i, shifted);
        }

        return result.toString();
    }
}