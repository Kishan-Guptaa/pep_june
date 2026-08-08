class Solution {
    HashMap<String,Integer>memo = new HashMap<>();
    public int findMaxForm(String[] strs, int m, int n) {
        return solve(strs,0,m,n);
    }
    private int solve(String[] strs, int index, int m, int n){
        if(index == strs.length){
            return 0;
        }
        String key = index + "," + m + "," + n;
        if(memo.containsKey(key)){
            return memo.get(key);
        }
        int one = 0;
        int zero = 0;
        for(char c : strs[index].toCharArray()){
            if(c == '0'){
                zero++;
            }
            else{
                one++;
            }
        }
        int notTaken = solve(strs,index+1,m,n);
        int take = 0;
        if(zero <= m && one <= n){
            take = 1 + solve(strs,index+1, m-zero, n-one);
        };

        int ans =  Math.max(take, notTaken);
        memo.put(key,ans);
        return ans;
    }
}