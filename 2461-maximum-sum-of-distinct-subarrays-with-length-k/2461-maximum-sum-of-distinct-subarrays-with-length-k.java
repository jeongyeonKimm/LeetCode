class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;

        HashSet<Integer> set = new HashSet<>();
        long sum = 0;
        long maxSum = 0;
        int start = 0;
        int end = 0;

        while (end < n) {
            if (set.contains(nums[end])) {
                set.remove(nums[start]);
                sum -= nums[start];
                start++;
                continue;
            }

            sum += nums[end];
            set.add(nums[end]);
            end++;

            if (end - start == k) {
                maxSum = Math.max(maxSum, sum);
                set.remove(nums[start]);
                sum -= nums[start];
                start++;
            }
        }

        return maxSum;
    }
}