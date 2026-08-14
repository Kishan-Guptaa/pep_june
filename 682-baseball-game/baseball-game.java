class Solution {
    public int calPoints(String[] operations) {
        int ans = 0;
        Stack<Integer>st = new Stack<>();
        for(String op : operations){
            switch(op){
                case "C" : 
                    st.pop();
                    break;
                case "D":
                    st.push(2 * st.peek());
                    break;
                case "+":
                    st.push(st.get(st.size() - 1) + st.get(st.size() - 2));
                    break;
                default:
                    st.push(Integer.parseInt(op));
            }
        }
        for(int sc : st){
            ans += sc;
        }
        return ans;
    }
}