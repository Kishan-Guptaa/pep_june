class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int base = 0;
        for(int i=0; i<n; i++){
            if(grumpy[i] == 0){
                base += customers[i];
            }
        }

        int window = 0;
        for(int i=0; i<minutes; i++){
            if(grumpy[i] == 1){

                window += customers[i];
            }
        }

        int maxExtra = window;
        for(int right = minutes; right<n; right++){
            if(grumpy[right] == 1){
                window += customers[right];
            }
            int left = right - minutes;
            if(grumpy[left] == 1){
                window -= customers[left];
            }
            maxExtra = Math.max(maxExtra, window);
        }

        return base + maxExtra;
    }
}