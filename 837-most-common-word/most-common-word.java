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
        for(String word : words){
            if(word.length() == 0){
                continue;
            }
            if(set.contains(word)){
                continue;
            }
            map.put(word, map.getOrDefault(word, 0 ) + 1);
        }

        String ans = "";
        int max = 0;
        for(String word : map.keySet()){
            if(map.get(word) > max){
                max = map.get(word);
                ans = word;
            }
        }
        return ans;

    }
}