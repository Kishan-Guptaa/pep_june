class Solution {
    public int minimumLengthEncoding(String[] words) {
        Set<String>set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }
        for(String word : words){
            for(int i=1; i<= word.length(); i++){
                String suffix = word.substring(i);
                set.remove(suffix);
            }
        }
        int ans = 0;
        for(String word : set){
            ans += word.length() + 1;
        }
        return ans;
    }
}