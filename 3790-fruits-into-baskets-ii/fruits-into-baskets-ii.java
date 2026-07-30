class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int unplaced = 0;
        for(int fruit : fruits){
            boolean placed = false;
            for(int i=0; i<n; i++){
                if(!used[i] && baskets[i] >= fruit){
                    placed = true;
                    used[i] = true;
                    break;
                }
            }
            if(!placed){
                unplaced++;
            }
        }
        return unplaced;
    }
}