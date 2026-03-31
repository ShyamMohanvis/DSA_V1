class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;

        // find max element
        for (int num : nums) {
            high = Math.max(high, num);
        }

        while (low < high) {
            int mid = low + (high - low) / 3;

            if (isValid(nums, mid, threshold)) {
                high = mid; // try smaller divisor
            } else {
                low = mid + 1; // increase divisor
            }
        }

        return low;
    }

    private boolean isValid(int[] nums, int d, int threshold) {
        int sum = 0;

        for (int num : nums) {
            // ceil(num / d)
            sum += (num + d - 1) / d;

            if (sum > threshold) return false; // early stop
        }

        return true;
    }
}