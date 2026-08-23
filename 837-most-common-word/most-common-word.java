class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        HashSet<String>set = new HashSet<>();
        for(String ban : banned){
            set.add(ban.toLowerCase());
        }

        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-z]", " ");
        String[] words = paragraph.split(" ");
        HashMap<String, Integer>map = new HashMap<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for(String word : words){
            if(word.length() == 0){
                continue;
            }
            if(set.contains(word)){
                continue;
            }
            map.put(word, map.getOrDefault(word, 0 ) + 1);
            if (map.get(word) > count) {
                sb = new StringBuilder(word);
                count = map.get(word);
            }
        }
        return sb.toString();

    }
}