class Solution {
    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int mid = arr[(n-1) / 2];
        int[] ans = new int[k];
        int index = 0;
        int left = 0;
        int right = n-1;
        while(index < k){
            int leftSide = Math.abs(arr[left] - mid);
            int rightSide = Math.abs(arr[right] - mid);
            if(leftSide > rightSide){
                ans[index++] = arr[left++];
            } 
            else{
                ans[index++] = arr[right--];
            }
        }
        return ans;
    }
}