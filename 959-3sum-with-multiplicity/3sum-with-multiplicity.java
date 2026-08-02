class Solution {
    public int threeSumMulti(int[] arr, int target) {
        int MOD = 1000000007;
        Arrays.sort(arr);
        int ans = 0;
        int  n = arr.length;
        for(int i=0; i<n-2; i++){
            int left = i+1;
            int right = n-1;
            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];
                if(sum < target){
                    left++;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    if(arr[left] != arr[right]){
                        int leftCount = 1;
                        int rightCount = 1;
                        while(left + 1 < right && arr[left] == arr[left+ 1]){
                            leftCount++;
                            left++;
                        }

                        while(right - 1 > left && arr[right] == arr[right-1]){
                            rightCount++;
                            right--;
                        }

                        ans = (ans + leftCount * rightCount) % MOD;
                        left++;
                        right--;
                    }
                    else{
                        int m = right - left + 1;
                        ans = (ans + m * (m - 1) / 2) % MOD;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}