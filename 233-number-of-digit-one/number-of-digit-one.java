class Solution {
    public int countDigitOne(int n) {
        int count = 0;
        for(int i=1; i<=n; i*=10){
            int higher = n / (i * 10);     //i = position
            int current = (n / i) % 10;
            int lower = (n % i);

            if(current == 0){
                count += higher * i;
            }
            else if(current == 1){
                count += higher * i + lower + 1;
            }
            else{
                count += (higher + 1) * i;
            }
        }
        return count;
    }
}