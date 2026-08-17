class Solution {
    public long bowlSubarrays(int[] nums) {
        Stack<Integer>st = new Stack<>();
        long ans = 0;
        for(int i=0; i<nums.length; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                int j = st.pop();
                if(i - j >= 2){
                    ans++;
                }
            }
            st.push(i);

        }

        st.clear();
        
        for(int i=nums.length-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                int j = st.pop();
                if( j-i >= 2){
                    ans++;
                }
            }
            st.push(i);
        }
        return ans;
    }
}