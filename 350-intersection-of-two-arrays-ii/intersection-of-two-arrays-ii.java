class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(map.containsKey(nums1[i])){
                int temp = map.get(nums1[i]);
                map.put(nums1[i], temp + 1);
            }
            else{
                map.put(nums1[i], 1);
            }
        }
        List<Integer>ans = new ArrayList<>();
        for(int num : nums2){
            if(map.containsKey(num) && map.get(num) > 0){
                ans.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}