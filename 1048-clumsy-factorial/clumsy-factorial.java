class Solution {
    public int clumsy(int n) {
        Stack<Integer>st = new Stack<>();
        st.push(n);
        n--;
        int oper = 0;
        while(n > 0){
            if(oper == 0){
                st.push(st.pop() * n);
            }
            else if(oper == 1){
                st.push(st.pop() / n);
            }
            else if(oper == 2){
                st.push(n);
            }
            else{
                st.push(-n);
            }
            oper = (oper + 1) % 4;
            n--;
        }
        int ans = 0;
        for(int s : st){
            ans += s;
        }
        return ans;
    }
}