class Solution {
    public int minInsertions(String s) {
        int ans = 0;
        int right = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                if(right % 2 == 1){
                    ans++;
                    right--;

                }
                right += 2;
            }
            else{
                right--;
                if(right < 0){
                    ans++;
                    right += 2;
                }
            }
        }
        return ans+right;
    }
}