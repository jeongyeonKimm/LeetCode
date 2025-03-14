class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandyPile = 0;
        for (int candy : candies) {
            maxCandyPile = Math.max(maxCandyPile, candy);
        }

        int left = 0;
        int right = maxCandyPile;

        while (left < right) {
            int mid = (left + right + 1) / 2;

            if (canAllocateCandies(candies, mid, k)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left;
    }

    private boolean canAllocateCandies(int[] candies, int mid, long k) {
        long count = 0;

        for (int i = 0; i < candies.length; i++) {
            if (candies[i] >= mid) {
                count += candies[i] / mid;
            }
        }

        return count >= k;
    }
}