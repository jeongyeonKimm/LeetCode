class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int xor1 = 0, xor2 = 0;

        if (m % 2 != 0) {
            for (int num : nums2) {
                xor2 ^= num;
            }
        }

        if (n % 2 != 0) {
            for (int num : nums1) {
                xor1 ^= num;
            }
        }

        return xor1 ^ xor2;
    }
}