class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
       int sum = 0;
       int ans = 0;

       for(int i=0; i<k; i++){
        sum += arr[i];
       } 
       if(sum >= k * threshold){
        ans++;
       }

       for(int right = k; right < arr.length; right++){
        int left = right - k;
        sum -= arr[left];
        sum += arr[right];
        if(sum >= k * threshold){
            ans++;
        }
       }
        return ans;
    }
}