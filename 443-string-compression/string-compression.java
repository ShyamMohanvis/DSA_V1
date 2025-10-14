class Solution {
    public int compress(char[] chars) {
        String s = "" + chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            char curr = chars[i];
            char prev = chars[i - 1];
            if (curr == prev) {
                count++;
            } else {
                if (count > 1) s += count;
                s += curr;
                count = 1;
            }
        }
        if (count > 1) s += count;
        for (int i = 0; i < s.length(); i++) chars[i] = s.charAt(i);
        return s.length();
    }
}
