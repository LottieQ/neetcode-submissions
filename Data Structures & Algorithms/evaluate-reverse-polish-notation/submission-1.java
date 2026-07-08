class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(String str: tokens){
            if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")){
                int a = stack.pop();
                int b = stack.pop();
                int result = switch(str){
                    case "+" -> b + a;
                    case "-" -> b - a;
                    case "*" -> b * a;
                    case "/" -> b / a;
                    default -> 0;
                };
                stack.push(result);
            }else{
                int num = Integer.parseInt(str);
                stack.push(num);
            }
        }
        
        return stack.pop();
    }
}
