class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        int idx1 = -1;
        int idx2 = -1;
        int count = 0;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;

                if (idx1 == -1) idx1 = i;
                else if (idx2 == -1) idx2 = i;
            }
        }

        if (count == 0) return true;
        if (count == 2 && s1.charAt(idx1) == s2.charAt(idx2) && s1.charAt(idx2) == s2.charAt(idx1)) return true;
        return false;
    }
}