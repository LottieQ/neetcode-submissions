class MedianFinder {

    PriorityQueue<Integer> bigSet;
    PriorityQueue<Integer> smallSet;
    double median = 0;
    
    public MedianFinder() {
        bigSet = new PriorityQueue<>();
        smallSet = new PriorityQueue<>((a , b) -> b - a);
    }
    
    public void addNum(int num) {
        if(bigSet.isEmpty() || num > bigSet.peek()){
            bigSet.offer(num);
        }else{
            smallSet.offer(num);
        }
        
        if(bigSet.size() - smallSet.size() > 1){
            smallSet.offer(bigSet.poll());
        }

        if(bigSet.size() - smallSet.size() < -1){
            bigSet.offer(smallSet.poll());
        }

        if(bigSet.size() == smallSet.size()){
            median = (bigSet.peek() + smallSet.peek()) / 2.0;
        }else if(bigSet.size() > smallSet.size()){
            median = (double)bigSet.peek();
        }else{
            median = (double)smallSet.peek();
        }
    }
    
    public double findMedian() {
        return median;
    }
}
