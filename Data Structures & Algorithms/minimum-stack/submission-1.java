class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> trackMin;
     
    public MinStack() {
        stack = new ArrayDeque<>();
        trackMin = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(trackMin.isEmpty()){
            trackMin.push(val);
        }else{
            trackMin.push(Math.min(val, trackMin.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        trackMin.pop();
        return;
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return trackMin.peek();
    }
}
