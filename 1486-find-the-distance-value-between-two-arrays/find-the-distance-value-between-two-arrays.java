class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for(int num : arr1){
            int index = closestElement(arr2, num);
            boolean valid = true;
            if(index < arr2.length && Math.abs(num - arr2[index]) <= d){
                valid = false;
            }
            if(index > 0 && Math.abs(num - arr2[index-1]) <= d){
                valid = false;
            }
            if(valid){
                count++;
            }
        }
        return count;
    }
    private int closestElement(int[] arr, int target){
        int left = 0;
        int right = arr.length;
        while(left < right){
            int mid = (left + right) / 2;
            if(arr[mid] < target){
                left = mid + 1;
            }
            else{
                right = mid;
            }
        }
        return left;
    }
}