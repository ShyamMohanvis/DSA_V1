class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(map.containsKey(ch)){
                int old_freq=map.get(ch);
                int new_freq=old_freq+1;
                map.put(ch,new_freq);
            }else{
                map.put(ch,1);
            }
        }
         for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (map.get(ch) == 1) {
                return i; 
            }
         }
    return -1;
    }
}