class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        int[] count = new int[26];

        // count letters in magazine
        for(char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }

        // try to build ransomNote
        for(char c : ransomNote.toCharArray()) {

            // use one character
            count[c - 'a']--;

            // if not available → false
            if(count[c - 'a'] < 0) return false;
        }

        return true;
    }
}