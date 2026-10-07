class Solution {
    public int distributeCandies(int[] candyType) {
        int size = candyType.length / 2;
        HashSet<Integer>set = new HashSet<>();
        for(int candy : candyType){
            set.add(candy);
        }
        return Math.min(size, set.size());
    }
}