class Solution {
    static int mod  = 1000_000_007;
    public int countGoodNumbers(long n) {
        long evenPosition = (n+1) / 2;
        long oddPosition = n/2;

        long ans1 = power(5, evenPosition);
        long ans2 = power(4, oddPosition);

        return (int) ((ans1 * ans2) % mod);
    }
    private long power(long base, long exp){
        long ans = 1;
        while(exp > 0){
            if(exp % 2 == 1){
                ans = (ans * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp / 2;
        }
        return ans;
    }
}