class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] arr = new int[2 * n];
        int left = 0;
        int right = n;
        int pos = 0;

        while (left < n && right < 2 * n) {
            arr[pos++] = nums[left++];
            arr[pos++] = nums[right++];
        }

        return arr;
    }
}