class Solution {
    public int maxSumMinProduct(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        for(int i=0; i<n; i++){
            prefix[i+1] = nums[i] + prefix[i];
        }
        Stack<Integer>st = new Stack<>();
        long ans = 0;
        for(int i=0; i<=n; i++){
            int curr = (i == n) ? 0 : nums[i];
            while(!st.isEmpty() && nums[st.peek()] > curr){
                int index = st.pop();
                int left = st.isEmpty() ? 0 : st.peek() + 1;
                int right = i - 1;
                long sum = prefix[right + 1] - prefix[left];
                long product = sum * nums[index];
                ans = Math.max(product, ans);
            }
            if(i < n){
                st.push(i);
            }
        }
        return  (int)(ans % 1000000007);
    }
}