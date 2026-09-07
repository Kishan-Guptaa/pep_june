class Solution {
    public int distinctSubseqII(String s) {
        long MOD = 1_000_000_007;
        long total = 0;
        long[] last = new long[26];

        for(char ch : s.toCharArray()){
            int index = ch - 'a';
            long newTotal = (2 * total + 1 - last[index] + MOD) % MOD;
            last[index] = (total + 1) % MOD;
            total = newTotal;
        }
        return (int)total;
    }
}