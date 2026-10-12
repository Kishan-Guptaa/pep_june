class Solution {
    public int findKthPositive(int[] arr, int k) {
        HashSet<Integer>set = new HashSet<>();
        for(int val : arr){
            set.add(val);
        }
        int num = 1;
        while(k > 0){
            if(!set.contains(num)){
                k--;
            }
            num = num+1;
        }
        return num-1;
    }
}