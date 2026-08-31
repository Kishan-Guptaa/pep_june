class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Stack<Integer>st = new Stack<>();
        int left = n; 
        int right = 0;
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                left = Math.min(left, st.pop());
            }
            st.push(i);
        }

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                right = Math.max(right, st.pop());
            }   
            st.push(i);
        }

        return right > left ? right - left + 1 : 0;
    }
}