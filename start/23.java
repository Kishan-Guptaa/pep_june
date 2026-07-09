// https://takeuforward.org/plus/dsa/problems/minimum-multiplications-to-reach-end?subject=dsa&approach=word-ladder-part-2

class Solution {
    public int minimumMultiplications(int[] arr, int start, int end) {
       if(start == end){
        return 0;
       }

       int n = arr.length;
       int mod = 100000;
       
       int[] minDist = new int[mod];
       Arrays.fill(minDist, Integer.MAX_VALUE);

       Queue<int[]>q = new LinkedList<>();
       q.add(new int[]{0, start});

       while(!q.isEmpty()){
        int[] p = q.remove();
        int step = p[0];
        int val = p[1];
        for(int i=0; i<n; i++){
            int num = (val * arr[i]) % mod;

            if(num == end){
                return step + 1;
            }

            if(step + 1 < minDist[num]){
                minDist[num] = step + 1;

                q.add(new int[]{step + 1, num});
            }
        }
       }

       return -1;
    }
}

