class Solution {
    private int[] findNSE(int[] heights){
        Stack<Integer>st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    private int[] findPSE(int[] heights){
        Stack<Integer>st = new Stack<>();
        int n = heights.length;
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        return ans;
    }
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = findPSE(heights);
        int[] nse = findNSE(heights);

        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = nse[i] - pse[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;

    }
}