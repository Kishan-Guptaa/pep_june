class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String>dead = new HashSet<>(Arrays.asList(deadends));
        Set<String>vis = new HashSet<>();
        if(dead.contains("0000")){
            return -1;
        }
        Queue<String>q = new LinkedList<>();
        q.add("0000");
        vis.add("0000");

        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                String current = q.remove();
                if(current.equals(target)){
                    return step;
                }
                for(int j=0; j<4; j++){
                    String up = turn(current, j, 1);
                    String down = turn(current, j, -1);

                    if(!dead.contains(up) && !vis.contains(up)){
                        vis.add(up);
                        q.add(up);
                    }
                    if(!dead.contains(down) && !vis.contains(down)){
                        vis.add(down);
                        q.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
        
    }
    private String turn(String current, int index, int direction){
        char[] chars = current.toCharArray();

        int digit = chars[index] - '0';
        
        digit = (digit + direction + 10) % 10;

        chars[index] = (char) (digit + '0');

        return new String(chars);
    }
}