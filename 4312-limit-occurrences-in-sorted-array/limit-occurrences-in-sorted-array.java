class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        ArrayList<Integer>arr = new ArrayList<>();
        for(int num : map.keySet()){
            int value = map.get(num);
            for(int i=0; i<Math.min(value, k); i++){
                arr.add(num);
            }
        }
        int[] result = new int[arr.size()];
        for(int i=0; i<arr.size(); i++){
            result[i] = arr.get(i);
        }
        Arrays.sort(result);
        return result;
    }
}