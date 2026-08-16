class Solution {
    public int totalSteps(int[] nums) {
        Stack<int[]>st = new Stack<>();
        int ans = 0;
        for(int num : nums){
            int step = 0;
            while(!st.isEmpty() && st.peek()[0] <= num){
                step = Math.max(step,st.pop()[1]);
            }
            if(!st.isEmpty()){
                step++;
            }
            ans = Math.max(ans,step);
            st.push(new int[]{num,step});
        }
        return ans;
    }
}