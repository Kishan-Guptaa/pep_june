class Solution {
    public int longestBeautifulSubstring(String word) {
        int left = 0;
        int ans = 0;
        int distinct = 1;
        for(int right = 1; right<word.length(); right++){
            if(word.charAt(right) < word.charAt(right - 1)){
                left = right;
                distinct = 1;
            }
            else if(word.charAt(right) != word.charAt(right-1)){
                distinct++;
            }
            if(distinct == 5){
                ans = Math.max(ans, right - left + 1);
            }

        }
        return ans;
    }
}