class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        boolean[] toggle = new boolean[101];
        for(int i=0; i<bulbs.size(); i++){
            int bulb = bulbs.get(i);
            toggle[bulb] = !toggle[bulb];
        }
        List<Integer>ans = new ArrayList<>();
        for(int i=0; i<=100; i++){
            if(toggle[i]){
                ans.add(i);
            }
        }
        return ans;
    }
}