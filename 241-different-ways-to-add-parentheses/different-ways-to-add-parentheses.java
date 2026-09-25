class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer>res = new ArrayList<>();
        for(int i=0; i<expression.length(); i++){
            char c = expression.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                List<Integer>leftSide = diffWaysToCompute(expression.substring(0,i));
                List<Integer>rightSide = diffWaysToCompute(expression.substring(i+1));
                for(int left : leftSide){
                    for(int right : rightSide){
                        int val = 0;
                        if(c == '+'){
                            val = left + right;
                        }
                        else if(c == '-'){
                            val = left - right;
                        }
                        else{
                            val = left * right;
                        }
                        res.add(val);
                    }
                }
            }
        }
        if(res.isEmpty()){
            res.add(Integer.parseInt(expression));
        }
        return res;
    }
}