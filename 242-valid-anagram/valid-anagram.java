class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(int i=0; i<s.length(); i++){
            count[s.charAt(i) - 'a']++;
        }
        for(char ch : t.toCharArray()){
            count[ch - 'a']--;
        }
        for(int digit : count){
            if(digit != 0){
                return false;
            }
        }
        return true;
    }
}