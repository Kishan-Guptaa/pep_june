class Solution {
    public int minimumCardPickup(int[] cards) {
        
        // int ans = Integer.MAX_VALUE;
        // for(int right = 0; right < cards.length; right++){
        //     int left = right-1;
        //     while(left >= 0){
        //         if(cards[left] == cards[right]){
        //             int find = right - left + 1;
        //              ans = Math.min(find, ans);
        //              break;
        //         }
        //         left--;
                
        //     }
        // }
        // return ans == Integer.MAX_VALUE ? -1 : ans;
        int ans = Integer.MAX_VALUE;
        HashMap<Integer, Integer>map = new HashMap<>();
        for(int i = 0; i<cards.length; i++){
            if(map.containsKey(cards[i])){
                int prevIndex = map.get(cards[i]);
                int find = i - prevIndex + 1;
                ans = Math.min(find, ans);

            }
            
            map.put(cards[i], i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}