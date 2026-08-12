class Solution {
    public int removePalindromeSub(String s) {
        if(s.length() == 0){
            return 0;
        }

        if(isPalindrom(s)){
            return 1;
        }

        return 2;
    }
    private boolean isPalindrom(String s){
        int left = 0;
        int right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}