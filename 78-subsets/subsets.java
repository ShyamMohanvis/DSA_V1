class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, new ArrayList<>(), res);
        return res;
    }

    void backtrack(int i, int[] nums, ArrayList<Integer> list, List<List<Integer>> res) {

    
        if (i == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

      
        list.add(nums[i]);
        backtrack(i + 1, nums, list, res);

       
        list.remove(list.size() - 1);

      
        backtrack(i + 1, nums, list, res);
    }
}
