class Solution {
    public long maximumSumOfHeights(int[] heights) {
        int n = heights.length;
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                left[i] = (long)heights[i] * (i+1);
            }
            else{
                int prev = st.peek();
                left[i] = left[prev] + (long) heights[i] * (i - prev);
            }
            st.push(i);
        }
        st.clear();

        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }

            if(st.isEmpty()){
                right[i] = (long)heights[i] * (n - i);
            }
            else{
                int next = st.peek();
                right[i] = right[next] + (long)heights[i] * (next - i);
            }
            st.push(i);
        }

        long ans = 0;
        for(int i=0; i<n; i++){
            long total = left[i] + right[i] - heights[i];
            ans = Math.max(ans, total);
        }
        return ans;
    }
}