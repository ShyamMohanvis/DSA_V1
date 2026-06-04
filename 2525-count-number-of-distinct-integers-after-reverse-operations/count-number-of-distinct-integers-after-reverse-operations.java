import java.util.*;

class Solution {
    public int countDistinctIntegers(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            set.add(num);

            int rev = 0;
            while (num > 0) {
                int lastDigit = num % 10;
                rev = rev * 10 + lastDigit;
                num = num / 10;
            }

            set.add(rev);
        }

        return set.size();
    }
}