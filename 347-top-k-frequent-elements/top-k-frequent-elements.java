class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i =0; i<nums.length;i++){
            int val = nums[i];
            if (map.containsKey(val)){
                int old_freq=map.get(val);
                int new_freq=old_freq+1;
                map.put(val,new_freq);
            }else{
                map.put(val,1);
            }
    
        }
        // Put map entries into a list
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());

        //  Sort by frequency in descending order
        list.sort((a, b) -> b.getValue() - a.getValue());

       
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i).getKey();
        }

        return result;
    }
}