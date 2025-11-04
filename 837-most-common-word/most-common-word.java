class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        
        String[] words = paragraph.split("\\s+");
        
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                if(map.containsKey(word)){
                int old_freq=map.get(word);
                int new_freq=old_freq+1;
                map.put(word,new_freq);
            }else{
                map.put(word,1);
            }
            }
        }

        String mostCommon = "";
        int maxCount = 0;
        for (String word : map.keySet()) {
            if (map.get(word) > maxCount) {
                maxCount = map.get(word);
                mostCommon = word;
            }
        }

        return mostCommon;
        
    }
}