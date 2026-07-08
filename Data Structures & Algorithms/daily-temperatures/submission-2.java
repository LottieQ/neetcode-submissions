class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Pair> stack = new ArrayDeque<>();
        int[] ans = new int[temperatures.length];

        for(int i = 0; i < temperatures.length; i++){
            Pair curr = new Pair(i, temperatures[i]);
            while(!stack.isEmpty() && curr.getValue() > stack.peek().getValue()){
                int idx = stack.pop().getIdx();
                ans[idx] = curr.getIdx() - idx;
            }
            stack.push(curr);
        }
        return ans;
    }
}

class Pair{
    private int idx;
    private int value;

    public Pair(int idx, int value){
        this.idx = idx;
        this.value = value;
    }

    public int getValue(){
        return value;
    }

    public int getIdx(){
        return idx;
    }
}
