class Solution {
    public int longestContinuousSubstring(String s) {
        int count = 1;
        int longest = 1;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i) == s.charAt(i-1) + 1){
                count++;
            }
            else{
                count = 1;
            }
            longest = Math.max(longest, count);
        }
        return longest;
    }
}