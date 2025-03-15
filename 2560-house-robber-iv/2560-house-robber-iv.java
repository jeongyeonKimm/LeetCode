class Solution {
    public int minCapability(int[] nums, int k) {
        int n = nums.length;

        int min = 1;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }

        while (min < max) {
            int mid = (min + max) / 2;

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid) {
                    count++;
                    i++;
                }
            }

            if (count >= k) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min;
    }
}