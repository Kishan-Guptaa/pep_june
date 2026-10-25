class Solution {
    public int countPairs(int[] deliciousness) {
        int mod = 1000_000_007;
        int maxSum =  1 << 21;
        int ans = 0;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int num : deliciousness){
            for(int power = 1; power<=maxSum; power <<= 1){
                int comple = power - num;
                ans = (ans + map.getOrDefault(comple,0)) % mod;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return ans;
    }
}