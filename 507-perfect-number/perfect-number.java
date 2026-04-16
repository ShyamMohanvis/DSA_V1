class Solution {
    public boolean checkPerfectNumber(int num) {
        if(num == 1){
            return false;
        }
        int sum = 1;
        for (int i = 2; i*i <= num; i++) {
             if(num % i == 0) {
                 if(num/i == i){
                     sum += i;
                 }
                 else {
                     sum += num / i;
                     sum += i;
                 }
            }
        }
        return sum == num;
    }
}