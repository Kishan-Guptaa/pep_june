class Solution {
    public List<String> generateParenthesis(int n) {
        List<String>res = new ArrayList<>();
        helper(res,"",0,0,n);
        return res;
    }
    private void helper(List<String>res, String current, int open, int close, int n){
        if(current.length() == 2 * n){
            res.add(current);
            return;
        }
        if(open < n){
            helper(res, current + '(', open + 1, close, n);
        }
        if(close < open){
            helper(res, current + ')', open, close + 1, n);
        }
    }
}