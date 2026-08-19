class Solution {
    public int lastRemaining(int n) {
        int step = 1;
        int head = 1;
        boolean left = true;
        int rem = n;
        while(rem > 1){
            if(left == true || rem % 2 == 1){
                head += step;
            }
            rem = rem / 2;
            step *= 2;
            left = !left;

        }

        return head;
        
    }
}