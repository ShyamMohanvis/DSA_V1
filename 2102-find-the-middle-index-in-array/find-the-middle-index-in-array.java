class Solution {
    public int findMiddleIndex(int[] nums) {
        int total = 0;
        
        // Step 1: total sum
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;

        // Step 2: iterate
        for (int i = 0; i < nums.length; i++) {
            int rightSum = total - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i; // found middle index
            }

            leftSum += nums[i];
        }

        return -1;
    }
}