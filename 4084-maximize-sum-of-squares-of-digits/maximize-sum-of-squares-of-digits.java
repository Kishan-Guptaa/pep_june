class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        while(sum >= 9 && ans.length() < num){
            ans.append('9');
            sum -= 9;
        }
        if(sum > 0 && ans.length() < num){
            ans.append(sum);
        }
        while(ans.length() < num){
            ans.append("0");
        }
        return ans.toString();
    }
}