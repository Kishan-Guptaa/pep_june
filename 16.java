https://www.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1


class Solution {
    public int maxSubarraySum(int[] arr, int k) {
    int n = arr.length;
     if(k>n){
         return 0;
     }
     int sum = 0;
     for(int i=0;i<k;i++){
         sum += arr[i];
     }
     int windowsum = sum;
     for(int i=k;i<n;i++){
         windowsum += arr[i] - arr[i-k];
         sum = Math.max(windowsum,sum);
     }
     return sum;
    }
}
