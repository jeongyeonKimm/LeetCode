class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int[] existingNum = new int[10001];
        for (int b : banned) {
            existingNum[b] = 1;
        }

        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (existingNum[i] == 1) continue;

            sum += i;
            if (sum > maxSum) break;

            count++;
        }

        return count;
    }
}