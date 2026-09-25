class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        for(int i=0; i<n; i++){
            int com = target - numbers[i];
            int index = binarySearch(numbers, i+1, n-1, com);
            if(index != -1){
                return new int[]{i+1, index+1};
            }
        }
        return new int[]{-1, -1};
    }
    private int binarySearch(int[] number, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) / 2;
            if(number[mid] == target){
                return mid;
            }
            else if(number[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}