class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] prefix = new int[n+1];
        for(int i=0; i<n; i++){
            if(hours[i] > 8){
                prefix[i+1] = prefix[i]  + 1;
            }
            else{
                prefix[i+1] = prefix[i] - 1;
            }
        }
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<=n; i++){
            if(st.isEmpty() || prefix[st.peek()] > prefix[i]){
                st.push(i);
            }
        }

        int ans = 0;
        for(int i=n; i>=0; i--){
            while(!st.isEmpty() && prefix[st.peek()] < prefix[i]){
                int j = i - st.pop();
                ans = Math.max(ans,j);
            }
        }
        return ans;
    }
}