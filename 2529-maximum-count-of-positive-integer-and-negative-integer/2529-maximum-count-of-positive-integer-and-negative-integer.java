class Solution {
    public int maximumCount(int[] nums) {
        int neg = findLowerBound(nums);
        int pos = findUpperBound(nums);

        return Math.max(neg, nums.length - pos);
    }

    private int findLowerBound(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums.length;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }

    private int findUpperBound(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int answer = nums.length;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = mid;
            }
        }

        return answer;
    }
}