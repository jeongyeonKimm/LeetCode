class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minRank = ranks[0];
        int maxRank = ranks[0];
        for (int r : ranks) {
            minRank = Math.min(minRank, r);
            maxRank = Math.max(maxRank, r);
        }

        int[] frequency = new int[maxRank + 1];
        for (int r : ranks) {
            frequency[r]++;
        }

        long left = 1L;
        long right = (long) maxRank * cars * cars;

        while (left < right) {
            long mid = (left + right) / 2;
            long repaired = 0;

            for (int i = 1; i <= maxRank; i++) {
                repaired += frequency[i] * (long) Math.sqrt(mid / i);
            }

            if (repaired < cars) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
}