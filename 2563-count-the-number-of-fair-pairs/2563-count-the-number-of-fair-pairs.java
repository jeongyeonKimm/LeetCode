class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        return countLessAndEqualThanLimit(nums, upper) - countLessAndEqualThanLimit(nums, lower - 1);
    }

    private long countLessAndEqualThanLimit(int[] nums, int limit) {
        long count = 0;

        for (int left = 0, right = nums.length - 1; left < right; left++) {
            while (left < right && nums[left] + nums[right] > limit) {
                right--;
            }
            count += (right - left);
        }

        return count;
    }
}