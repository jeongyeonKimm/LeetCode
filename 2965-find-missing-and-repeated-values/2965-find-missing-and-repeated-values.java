class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;

        Set<Integer> hs = new HashSet<>();

        int a = -1;
        int b = -1;

        for (int[] row : grid) {
            for (int r : row) {
                if (hs.contains(r)) {
                    a = r;
                }
                hs.add(r);
            }
        }

        for (int i = 1; i <= n * n; i++) {
            if (!hs.contains(i)) {
                b = i;
                break;
            }
        }

        return new int[]{a, b};
    }
}