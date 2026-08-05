class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[nums.length];
        Arrays.fill(arr, -1);
        int window = 2 * k + 1;
        if(window > n){
            return arr;
        }

        long sum = 0;
        for(int i=0; i<window; i++){
            sum += nums[i];
        }
        arr[k] = (int) (sum / window);

        for(int right = window; right <n; right++){
            sum += nums[right];
            sum -= nums[right - window];
            int center = right - k;
            arr[center] = (int) (sum / window);
        }
        return arr;

    }
}