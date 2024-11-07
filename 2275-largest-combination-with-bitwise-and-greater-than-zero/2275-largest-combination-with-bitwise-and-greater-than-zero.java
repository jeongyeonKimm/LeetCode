class Solution {
    public int largestCombination(int[] candidates) {
        int maxLength = 0;

        for (int i = 0; i < 32; i++) {
            int count = 0;

            for (int c : candidates) {
                count += (c >> i) & 1;
            }

            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}