class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();

        int left = 0;
        int right = 0;
        int count = 0;
        int[] frequency = new int[3];

        while (right < n) {
            char r = s.charAt(right);
            frequency[r - 'a']++;

            while (hasAllCharacters(frequency)) {
                count += (n - right);
                char l = s.charAt(left);
                frequency[l - 'a']--;
                left++;
            }

            right++;
        }

        return count;
    }

    private boolean hasAllCharacters(int[] frequency) {
        return frequency[0] > 0 && frequency[1] > 0 && frequency[2] > 0;
    }
}