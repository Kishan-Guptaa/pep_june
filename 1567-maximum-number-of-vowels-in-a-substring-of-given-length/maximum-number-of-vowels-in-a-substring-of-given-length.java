class Solution {
    private boolean isVowel(char ch){
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
            return true;
        }
        else{
            return false;
        }
    }
    public int maxVowels(String s, int k) {
        int count = 0;
        int maxCount = 0;
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        maxCount = count;
        for(int i=k; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}