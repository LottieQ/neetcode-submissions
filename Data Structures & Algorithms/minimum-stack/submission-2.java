class MinStack {
    Deque<Integer> num;
    Deque<Integer> min;

    public MinStack() {
        num = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }
    
    public void push(int val) {
        num.push(val);
        if(min.isEmpty()){
            min.push(val);
        }else{
            min.push(Math.min(min.peek(), val));
        }
    }
    
    public void pop() {
        num.pop();
        min.pop();
    }
    
    public int top() {
        return num.peek();
    }
    
    public int getMin() {
        return min.peek();
    }
}
