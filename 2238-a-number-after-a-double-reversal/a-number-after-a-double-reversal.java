class Solution {
    public boolean isSameAfterReversals(int num) {

        int original = num;

        // First reversal
        int rev1 = 0;
        while (num > 0) {
            int lastDigit = num % 10;
            rev1 = rev1 * 10 + lastDigit;
            num = num / 10;
        }

        // Second reversal
        int rev2 = 0;
        while (rev1 > 0) {
            int lastDigit = rev1 % 10;
            rev2 = rev2 * 10 + lastDigit;
            rev1 = rev1 / 10;
        }

        return original == rev2;
    }
}