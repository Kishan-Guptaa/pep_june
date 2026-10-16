class Solution {
    public int countAnagrams(String s) {
        int mod = 1000_000_007;
        long ans = 1;
        String[] words = s.split(" ");
        for(String word : words){
            int n = word.length();
            int[] freq = new int[26];
            for(char ch : word.toCharArray()){
                freq[ch - 'a']++;
            }

            long numerator = 1;
            for(int i=1; i<=n; i++){
                numerator = numerator * i % mod;
            }

            long denominator = 1;
            for(int count : freq){
                for(int i=1; i<=count; i++){
                    denominator = denominator * i % mod;
                }
            }
            long inverse = modPow(denominator, mod - 2, mod);

            ans = ans * numerator % mod;
            ans = ans * inverse % mod;
        }
        return (int)ans; 
    }
    private long modPow(long base, long exp, int mod){
        long result = 1;
        while(exp > 0){
            if(exp % 2 == 1){
                result = result * base % mod;
            }
            base = base * base % mod;
            exp /= 2;
        }
        return result;
    }
}