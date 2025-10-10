import java.util.HashMap;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                
                return true;
            } else {
                freq.put(nums[i], 1); // first time seeing nums[i]
            }
        }
        return false; 
    }
}
