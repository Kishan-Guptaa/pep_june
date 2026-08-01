class Solution {
    public int expressiveWords(String s, String[] words) {
        int ans = 0;
        for(String word : words){
            if(isStrechy(s, word)){
                ans++;
            }
        }
        return ans;
    }
    private boolean isStrechy(String s, String word){
        int i = 0;
        int j = 0;
        while(i < s.length() && j < word.length()){
            if(s.charAt(i) != word.charAt(j)){
                return false;
            }

            int countS = 0;
            char ch = s.charAt(i);
            while(i < s.length() && s.charAt(i) == ch){
                countS++;
                i++;
            }

            int countW = 0;
            while(j < word.length() && word.charAt(j) == ch){
                countW++;
                j++;
            }

            if(countS < countW){
                return false;
            }

            if(countS != countW && countS < 3){
                return false;
            }
        }

        return i == s.length() && j == word.length();
    }
}