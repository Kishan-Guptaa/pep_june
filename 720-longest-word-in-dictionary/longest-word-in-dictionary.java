class Solution {
    public String longestWord(String[] words) {
        Set<String>set = new HashSet<>();
        for(String word : words){
            set.add(word);
        }

        String ans = "";
        for(String word : words){
            boolean valid = true;
            for(int i=1; i<word.length(); i++){
                String prefix = word.substring(0,i);
                if(!set.contains(prefix)){
                    valid = false;
                    break;
                }

            }
            if(valid){
                if(word.length() > ans.length() || word.length() == ans.length() && word.compareTo(ans) < 0){
                    ans = word;
                }
            }
           
        }
        return ans;
    }
}