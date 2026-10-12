class Solution {
    public String removeDigit(String number, char digit) {
        for(int i=0; i<number.length(); i++){
            if(number.charAt(i) == digit){
                if(i+1 < number.length() && number.charAt(i) < number.charAt(i+1)){
                    return number.substring(0,i) + number.substring(i+1);
                }
            }
        }
        int i = number.lastIndexOf(digit);
        return number.substring(0,i) + number.substring(i+1);
    }
}