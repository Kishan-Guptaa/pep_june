class Solution {
    public int[] dailyTemperatures(int[] tem) {
        int n = tem.length;
        Stack<Integer>st = new Stack<>();
        
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && tem[st.peek()] < tem[i]){
                int prev = st.pop();
                ans[prev] = i - prev;
            }
            
            st.push(i);
        }
        return ans;
    }
}