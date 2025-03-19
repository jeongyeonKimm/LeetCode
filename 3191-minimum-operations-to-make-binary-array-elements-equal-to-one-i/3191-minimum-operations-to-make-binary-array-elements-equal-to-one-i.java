class Solution {
    public int minOperations(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!deque.isEmpty() && i > deque.peekFirst() + 2) {
                deque.pollFirst();
            }

            if ((nums[i] + deque.size()) % 2 == 0) {
                if (i + 2 >= nums.length) return -1;
                count++;
                deque.offerLast(i);
            }
        }

        return count;
    }
}