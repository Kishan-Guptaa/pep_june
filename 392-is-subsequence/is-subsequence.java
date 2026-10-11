class Solution {
    public boolean isSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        return helper(s,t,n,m);
    }
    private boolean helper(String s, String t, int n, int m){
        if(n == 0){
            return true;
        }
        if(m == 0){
            return false;
        }
        if(s.charAt(n-1) == t.charAt(m-1)){
            return helper(s, t, n-1, m-1);
        }
        else{
            return helper(s, t, n, m-1);
        }
    }
}