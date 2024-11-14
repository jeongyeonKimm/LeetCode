class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int m = quantities.length;

        int left = 1;
        int right = 100000;
        int answer = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (canDistribute(n, quantities, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }

    private boolean canDistribute(int n, int[] quantities, int k) {
        int count = 0;

        for (int q : quantities) {
            count += q / k;
            if (q % k != 0) {
                count++;
            }
            
            if (count > n) {
                return false;
            }
        }

        return true;
    }
}