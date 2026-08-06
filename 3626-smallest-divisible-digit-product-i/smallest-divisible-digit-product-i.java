class Solution {
    private int pro(int n){
        int store = 1;
        while(n > 0){
            store *= n % 10;
            n = n / 10;
        }
        return store;
    }
    public int smallestNumber(int n, int t) {
        
        while(pro(n) % t != 0){
            n++;
        }
        return n;

    }
}