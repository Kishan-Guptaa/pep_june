class Solution {
    public boolean isPalindromic(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            String bits = String.format("%8s", Integer.toBinaryString(c)).replace(' ', '0');
            sb.append(bits);
        }
        int left = 0;
        int right = sb.length() - 1;
        while(left < right){
            if(sb.charAt(left) != sb.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}