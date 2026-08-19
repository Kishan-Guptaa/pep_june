class Solution {
    int mod = 1000_000_007;
    public int monkeyMove(int n) {
        return (int)(power(2,n) - 2 + mod) % mod;
    }
    private long power(long base, int exp){
        long result = 1;

        while(exp > 0){
            if(exp % 2 == 1){
                result = (base * result) % mod;
            } 
            base = (base * base )  % mod;
            exp /= 2;
        }
        return result;
    }
}