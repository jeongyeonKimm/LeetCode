class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;

        int start = 0;
        int end = n - 1;

        while (start < n - 1 && arr[start] <= arr[start + 1]) {
            start++;
        }

        if (start >= n - 1) {
            return 0;
        }

        while (end > 0 && arr[end] >= arr[end - 1]) {
            end--;
        }

        int result = Math.min(n - start - 1, end);

        int i = 0;
        int j = end;

        while (i <= start && j < n) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        } 

        return result;
    }
}