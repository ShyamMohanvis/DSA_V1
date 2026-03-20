class Solution {
    public String reverseVowels(String s) {

        char[] arr = s.toCharArray();
        int i = 0, j = arr.length - 1;

        while(i < j) {

            // move i until vowel
            while(i < j && !isVowel(arr[i])) i++;

            // move j until vowel
            while(i < j && !isVowel(arr[j])) j--;

            // swap vowels
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        return new String(arr);
    }

    // check vowel
    boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}