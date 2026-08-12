class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer>ans = new ArrayList<>();
        for(int size = arr.length; size >= 2; size--){
            int index = -1;
            for(int i=0; i<size; i++){
                if(arr[i] == size){
                    index = i;
                    break;
                }
            }

            if(index == size - 1){
                continue;
            }

            if(index != 0){
                reverse(arr,index+1);
                ans.add(index+1);
            }

            reverse(arr, size);
            ans.add(size);
        }
        return ans;
    }
    private void reverse(int[] arr, int end){
        int left = 0;
        int right = end-1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }
    }
}