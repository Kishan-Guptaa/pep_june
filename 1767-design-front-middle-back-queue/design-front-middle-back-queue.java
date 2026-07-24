class FrontMiddleBackQueue {
    Deque<Integer>left;
    Deque<Integer>right;
    public FrontMiddleBackQueue() {
        left = new ArrayDeque<>();
        right = new ArrayDeque<>();
    }
    private void rebalance(){
        if(left.size() > right.size()){
            right.addFirst(left.removeLast());
        }
        else if(right.size() > left.size() + 1){
            left.addLast(right.removeFirst());
        }
    }
    public void pushFront(int val) {
        left.addFirst(val);
        rebalance();
    }
    
    public void pushMiddle(int val) {
        left.addLast(val);
        rebalance();
    }
    
    public void pushBack(int val) {
        right.addLast(val);
        rebalance();
    }
    
    public int popFront() {
        if(left.isEmpty() && right.isEmpty()){
            return -1;
        }

        int ans;
        if(!left.isEmpty()){
            ans = left.removeFirst();
        }
        else{
            ans = right.removeFirst();
        }
        rebalance();
        return ans;
    }
    
    public int popMiddle() {
        if(left.isEmpty() && right.isEmpty()){
            return -1;
        }
        int ans;
        if(left.size() == right.size()){
            ans = left.removeLast();
        }
        else{
            ans = right.removeFirst();
        }
        rebalance();
        return ans;
    }
    
    public int popBack() {
        if(right.isEmpty()){
            return -1;
        }
        int ans = right.removeLast();
        rebalance();
        return ans;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */