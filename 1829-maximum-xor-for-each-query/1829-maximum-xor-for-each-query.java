class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int numsXor = nums[0];
        int n = nums.length;

        for (int i = 1; i < n; i++) {
            numsXor ^= nums[i];
        }

        int maxXor = (1 << maximumBit) - 1;

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = numsXor ^ maxXor;
            numsXor ^= nums[n - 1 - i];
        }

        return result;
    }
}