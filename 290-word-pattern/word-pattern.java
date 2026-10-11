class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if(pattern.length() != words.length){
            return false;
        }
        HashMap<Character, String>pmap = new HashMap<>();
        HashMap<String, Character>smap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String word = words[i];
            if(pmap.containsKey(ch)){
                if(!pmap.get(ch).equals(word)){
                    return false;
                }
            }
            else{
                pmap.put(ch, word);
            }
            if(smap.containsKey(word)){
                if(smap.get(word) != ch){
                    return false;
                }
            }
            else{
                smap.put(word,ch);
            }
        }
        return true;
    }
}