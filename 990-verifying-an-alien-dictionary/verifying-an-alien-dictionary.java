class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer>map = new HashMap<>();
        for(int i=0; i<order.length(); i++){
            char ch = order.charAt(i);
            map.put(ch, i);
        }

        for(int i=0; i<words.length-1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            
            int j=0;
            while(j < word1.length() && j < word2.length()){
                char ch1 = word1.charAt(j);
                char ch2 = word2.charAt(j);
                if(ch1 != ch2){
                    if(map.get(ch1) > map.get(ch2)){
                        return false;
                    }
                    break;
                }
                j++;
            }
            if (j == word2.length() && word1.length() > word2.length()) {
                return false;
            }
        }
        return true;
    }
}