class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;

        if (!checkZeroArray(nums, queries, right)) {
            return -1;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (checkZeroArray(nums, queries, mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean checkZeroArray(int[] nums, int[][] queries, int target) {
        int[] diffArray = new int[nums.length + 1];

        for (int i = 0; i < target; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];

            diffArray[l] += val;
            diffArray[r + 1] -= val;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += diffArray[i];
            if (sum < nums[i]) {
                return false;
            }
        }

        return true;
    }
}