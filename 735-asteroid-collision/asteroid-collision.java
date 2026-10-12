class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer>st = new Stack<>();
        for(int i=0; i<asteroids.length; i++){
            boolean des = false;
            while(!st.isEmpty() && st.peek() > 0 && asteroids[i] < 0){
                int top = st.peek();
                if(Math.abs(top) < Math.abs(asteroids[i])){
                    st.pop();
                    continue;
                }
                else if(Math.abs(top) == Math.abs(asteroids[i])){
                    st.pop();
                    des = true;
                    break;
                }
                else{
                    des = true;
                    break;
                }
            }
            if(!des){
                st.push(asteroids[i]);
            }
            
        }
        int[] ans = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            ans[i] = st.pop();
        }
        return ans;
    }
}