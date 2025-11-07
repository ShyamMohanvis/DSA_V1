class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) return false;

        if (s.equals(goal)) {
            Map<Character, Integer> freq = new HashMap<>();
            for (char c : s.toCharArray()) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                if (freq.get(c) > 1) return true; 
            }
            return false;
        }

        List<Integer> mismatch = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                mismatch.add(i);
                if (mismatch.size() > 2) return false;
            }
        }

        if (mismatch.size() == 2) {
            int i = mismatch.get(0), j = mismatch.get(1);
            return s.charAt(i) == goal.charAt(j) && s.charAt(j) == goal.charAt(i);
        }

        return false;
    }
}
