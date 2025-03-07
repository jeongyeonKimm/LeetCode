class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isNotPrime = new boolean[right + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;

        for (int i = 2; i <= right; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * 2; j <= right; j += i) {
                    if (!isNotPrime[j]) {
                        isNotPrime[j] = true;
                    }
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (!isNotPrime[i]) {
                primes.add(i);
            }
        }

        int size = primes.size();
        if (size < 2) {
            return new int[]{-1, -1};
        }

        int num1 = -1;
        int num2 = -1;
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < size; i++) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                minDiff = diff;
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
            }
        }

        return new int[]{num1, num2};
    }
}