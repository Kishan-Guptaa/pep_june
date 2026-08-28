class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer>freq = new HashMap<>();
        for(int arr : arr1){
            freq.put(arr, freq.getOrDefault(arr, 0) + 1);
        }
        int[] ans = new int[arr1.length];
        int index = 0;
        for(int num : arr2){
            if(freq.containsKey(num)){
                int count = freq.get(num);
                while(count > 0){
                    ans[index++] = num;
                    count--;

                }
                freq.remove(num);
            }
        }
        ArrayList<Integer>rem = new ArrayList<>();
        for(int num : freq.keySet()){
            int count = freq.get(num);
            while(count > 0){
                rem.add(num);
                count--;
            }
        }
        Collections.sort(rem);
        for(int num : rem){
            ans[index++] = num;
        }
        return ans;
    }
}