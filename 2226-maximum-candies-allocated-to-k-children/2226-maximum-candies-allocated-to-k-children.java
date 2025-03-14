class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxCandyPile = 0;
        for (int candy : candies) {
            maxCandyPile = Math.max(maxCandyPile, candy);
        }

        int left = 1;
        int right = maxCandyPile;
        int result = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canAllocateCandies(candies, mid, k)) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    private boolean canAllocateCandies(int[] candies, int mid, long k) {
        long count = 0;

        for (int candy : candies) {
            count += candy / mid;
            if (count >= k) return true;
        }

        return false;
    }
}