class Solution {
    public boolean isSameAfterReversals(int num) {
        int digit = num % 10;
        if(num == 0){
            return true;
        }
        if(digit == 0){
            return false;
        }
        else{
            return true;
        }
    }
}