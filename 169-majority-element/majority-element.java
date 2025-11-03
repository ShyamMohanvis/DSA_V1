import java.util.HashMap;

class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            if (map.containsKey(num)){
                int old_freq=map.get(num);
                int new_freq=old_freq+1;
                map.put(num,new_freq);
            }else{
                map.put(num,1);
            }

            if (map.get(num) > n / 2) {
                return num;
            }
        }

        return -1; 
    }
}
