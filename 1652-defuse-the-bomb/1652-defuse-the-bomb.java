class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];

        if (k == 0) {
            return result;
        }

        int start = 0;
        int end = 0;

        if (k > 0) {
            start = 1;
            end = k;
        } else {
            start = n + k;
            end = n - 1;
        }

        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += code[i];
        }

        for (int i = 0; i < n; i++) {
            result[i] = sum;
            sum = sum - code[start % n] + code[(end + 1) % n];
            start++;
            end++;
        }

        return result;
    }
}