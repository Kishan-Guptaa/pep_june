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
        for(int i=0; i<k; i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        int maxCount = count;
        for(int right=k; right<s.length(); right++){
            if(isVowel(s.charAt(right))){
                count++;
            }
            if(isVowel(s.charAt(right - k))){
                count--;
            }
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}