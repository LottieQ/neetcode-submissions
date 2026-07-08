class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        
        for(String string: tokens){
            switch(string){
                case "+" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(b + a));
                }
                case "-" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(b - a));
                }
                case "*" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(b * a));
                }
                case "/" -> {
                    int a = Integer.parseInt(stack.pop());
                    int b = Integer.parseInt(stack.pop());
                    stack.push(Integer.toString(b / a));
                }
                default -> {
                    stack.push(string);
                }
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
