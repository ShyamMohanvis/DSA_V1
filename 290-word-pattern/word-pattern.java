class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] words = s.split(" ");
        if(pattern.length() != words.length) return false;

        HashMap<Object, Integer> map = new HashMap<>();

        for(int i = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);
            String word = words[i];

            Integer p1 = map.put(ch, i);
            Integer p2 = map.put(word, i);

            // FIXED comparison
            if(p1 == null ? p2 != null : !p1.equals(p2)) return false;
        }

        return true;
    }
}