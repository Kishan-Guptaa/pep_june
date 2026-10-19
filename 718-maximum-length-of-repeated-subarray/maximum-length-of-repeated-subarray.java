class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int max = 0;
        for(int i=0; i<n; i++){
            int len = Math.min(m, n-i);
            max = Math.max(max, findMaxLen(nums1, nums2, i, 0, len));
        }

        for(int j=0; j<m; j++){
            int len = Math.min(n, m-j);
            max = Math.max(max, findMaxLen(nums1, nums2, 0, j, len));
        }

        return max;
    }
    private int findMaxLen(int[] a, int[] b, int i, int j, int len){
        int max = 0;
        int count = 0;
        for(int k=0; k<len; k++){
            if(a[k + i] == b[k + j]){
                count++;
                max = Math.max(max, count);
            }
            else{
                count = 0;
            }
        }
        return max;
    }
}