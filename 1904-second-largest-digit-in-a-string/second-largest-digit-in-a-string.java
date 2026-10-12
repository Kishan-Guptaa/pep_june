class Solution {
    public int secondHighest(String s) {
        int max = -1;
        int secMax = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                int num = ch - '0';
                if(num > max){
                    secMax = max;
                    max = num;
                }
                else if(num < max && secMax < num){
                    secMax = num;
                }
            }
        }
        return secMax;
    }
}