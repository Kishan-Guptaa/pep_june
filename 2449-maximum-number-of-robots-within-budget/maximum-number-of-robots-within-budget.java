class Solution {
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        int ans = 0;
        int left = 0;
        long sum = 0;
        Deque<Integer>deque = new ArrayDeque<>();

        for(int right = 0; right < chargeTimes.length; right++){
            sum += runningCosts[right];

            while(!deque.isEmpty() && chargeTimes[deque.peekLast()] <= chargeTimes[right]){
                deque.pollLast();
            }
            deque.addLast(right);

            while(!deque.isEmpty() && chargeTimes[deque.peekFirst()] + (right - left + 1) * sum > budget){
                if (deque.peekFirst() == left) {
                    deque.pollFirst();
                }

                sum -= runningCosts[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
        
    }
}