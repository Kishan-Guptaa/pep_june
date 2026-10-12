class Solution {
    public int minimumOperations(String num) {
        int n = num.length();
        int ans = n;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                String pair = "" + num.charAt(i) + num.charAt(j);
                if(pair.equals("00") || pair.equals("25") || pair.equals("75") || pair.equals("50")){
                    ans = Math.min(ans, n - i - 2);
                }
            }
        }
        if(num.contains("0")){
            ans = Math.min(ans, n - 1);
        }
        return ans;
    }
}