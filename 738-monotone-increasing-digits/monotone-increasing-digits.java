class Solution {
    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        char[] digits = s.toCharArray();
        int point = digits.length;
        for(int i = digits.length - 2; i>=0; i--){
            if(digits[i] > digits[i+1]){
                digits[i]--;
                point = i+1;
            }
        }
        for(int i=point; i<digits.length; i++){
            digits[i] = '9';
        }
        String str = new String(digits);
        return Integer.parseInt(str);
    }
}