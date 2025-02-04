class Solution {
    public int maxAscendingSum(int[] nums) {
        int cur = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            cur = nums[i] > nums[i - 1] ? cur + nums[i] : nums[i];
            result = Math.max(result, cur);
        }

        return result;
    }
}