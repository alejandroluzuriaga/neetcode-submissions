class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < tokens.length; i++){
            String c = tokens[i];
            if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") ){
                int left = 1;
                int operands[] = new int[2];
                    while(left > -1){
                        operands[left] = s.pop();
                        left--;
                    }
                    System.out.println(operands[0] + "-"+ operands[1]);
                    switch(c){
                            case "+": s.push(operands[0] + operands[1]); break;
                            case "-": s.push(operands[0] - operands[1]); break;
                            case "*": s.push(operands[0] * operands[1]); break;
                            case "/": s.push(operands[1] == 0 ? operands[0] : operands[0] / operands[1]); break;
                        }
            }
            else{
                s.push(Integer.parseInt(tokens[i]));
            }
        }
        return s.pop();
    }
}
