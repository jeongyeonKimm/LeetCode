class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;

        int[] prefix = new int[n];
        int count = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i - 1] % 2 != nums[i] % 2) {
                count++;
            }
            prefix[i] = count;
        }

        int m = queries.length;
        boolean[] result = new boolean[m];
        for (int i = 0; i < m; i++) {
            result[i] = true;
            if (prefix[queries[i][1]] - prefix[queries[i][0]] != queries[i][1] - queries[i][0]) {
                result[i] = false;
            }
        }

        return result;
    }
}