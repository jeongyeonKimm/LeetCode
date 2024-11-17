class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int len = nums.length;

        long[] sum = new long[len + 1]; // Cumulative sum up to the ith index
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }

        Deque<Integer> deque = new ArrayDeque<>();
        int minLength = len + 1;

        for (int i = 0; i <= len; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k) {
                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()]) {
                deque.pollLast();
            }

            deque.addLast(i);
        }

        return minLength == len + 1 ? -1 : minLength;
    }
}