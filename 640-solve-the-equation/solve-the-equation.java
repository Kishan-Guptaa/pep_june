class Solution {
    public String solveEquation(String equation) {
        String[] equ = equation.split("=");
        String left = equ[0];
        String right = equ[1];
        int[] ls = solve(left);
        int[] rs = solve(right);

        int x = ls[0] - rs[0];
        int value = rs[1] - ls[1];

        if(x == 0 && value == 0){
            return "Infinite solutions";
        }
        if(x == 0){
            return "No solution";
        }
        return "x=" + (value/x);
    }
    private int[] solve(String s){
        int cofficient = 0;
        int constant = 0;

        int sign = 1;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) == '+'){
                sign = 1;
                i++;
            }
            else if(s.charAt(i) == '-'){
                sign = -1;
                i++;
            }
            int num = 0;
            boolean hasNumber = false;

            while(i<s.length() && Character.isDigit(s.charAt(i))){
                num = num * 10 + (s.charAt(i) - '0');
                i++;
                hasNumber = true;
            }

            if(i < s.length() && s.charAt(i) == 'x'){
                if(!hasNumber){
                    num = 1;
                }

                cofficient += num * sign;
                i++;
            }
            else{
                constant += sign * num;
            }
        }
        return new int[]{cofficient, constant};
    }
}