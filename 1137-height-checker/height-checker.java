class Solution {
    public int heightChecker(int[] heights) {
        int[] ansWill = heights.clone();
        Arrays.sort(ansWill);
        int ans = 0;
        for(int i=0; i<heights.length; i++){
            if(heights[i] != ansWill[i]){
                ans++;
            }
        }
        return ans;
    }
}