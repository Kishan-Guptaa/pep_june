class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        List<int[]>nums = new ArrayList<>();
        int left = 0;
        int right = 1;
        while(right < arr.length){
            nums.add(new int[]{arr[left], arr[right]});
            left++;
            if(left == right){
                left = 0;
                right++;
            }
        }
        Collections.sort(nums, (a, b) -> {

            // a[0] / a[1]  vs  b[0] / b[1]
            return Integer.compare(
                a[0] * b[1],
                b[0] * a[1]
            );
        });
        int[] ans = nums.get(k-1);
        return ans;
    }
}