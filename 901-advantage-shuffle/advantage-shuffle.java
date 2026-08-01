class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer>map = new TreeMap<>();
        for(int num : nums1){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums2.length];
        for(int i=0; i<nums2.length; i++){
            Integer bigger = map.higherKey(nums2[i]);
            if(bigger != null){
                ans[i] = bigger;
                remove(map,bigger);
            }
            else{
                int smallest = map.firstKey();
                ans[i] = smallest;
                remove(map,smallest);
            }
        }
        return ans;
    }
    private void remove(TreeMap<Integer, Integer>map, int num){
        if(map.get(num) == 1){
            map.remove(num);
        }
        else{
            map.put(num, map.get(num) - 1);
        }
    }
}