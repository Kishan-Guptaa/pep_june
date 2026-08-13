class Solution {
    public boolean isPrefixString(String s, String[] words) {
        int index = 0;
        for(String word : words){
            for(int i=0; i<word.length(); i++){
                if(index >= s.length()){
                    return false;
                }

                if(s.charAt(index) != word.charAt(i)){
                    return false;
                }
                index++;
            }
            if(index == s.length()){
                return true;
            }
        }
        return false;
    }
}