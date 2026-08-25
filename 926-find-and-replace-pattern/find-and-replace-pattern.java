class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String>ans = new ArrayList<>();
        for(String word : words){
            if(matches(word, pattern)){
                ans.add(word);
            }
        }
        return ans;
    }
    private boolean matches(String word, String pattern){
        HashMap<Character, Character>map1 = new HashMap<>();
        HashMap<Character, Character>map2 = new HashMap<>();

        for(int i=0; i<word.length(); i++){
            char ch1 = word.charAt(i);
            char ch2 = pattern.charAt(i);
            if(map1.containsKey(ch2) && map1.get(ch2) != ch1){
                return false;
            }
            if(map2.containsKey(ch1) && map2.get(ch1) != ch2){
                return false;
            }
            map1.put(ch2, ch1);
            map2.put(ch1, ch2);
        }
        return true;
    }
}