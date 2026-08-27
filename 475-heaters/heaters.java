class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int j=0;
        int ans = 0;
        for(int house : houses){
            while(j+1 < heaters.length && Math.abs(house - heaters[j]) >= Math.abs(house - heaters[j+1])){
                j++;
            }
            int dist = Math.abs(house - heaters[j]);
            ans = Math.max(dist, ans);
        }

        return ans;
        
    }
}