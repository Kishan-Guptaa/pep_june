class Solution {
    private int[] findPSE(int[] heights, int n){
        Stack<Integer>st = new Stack<>();
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
    private int[] findNSE(int[] heights, int n){
        Stack<Integer>st = new Stack<>();
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
    private int largestRectangle(int[] heights){
        int n = heights.length;
        int[] pse = findPSE(heights, n);
        int[] nse = findNSE(heights, n);
        int maxArea = 0;
        for(int i=0; i<n; i++){
            int width = nse[i] - pse[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0){
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];
        int maxArea = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }
                else{
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestRectangle(heights));

        }
        return maxArea;
    }
}