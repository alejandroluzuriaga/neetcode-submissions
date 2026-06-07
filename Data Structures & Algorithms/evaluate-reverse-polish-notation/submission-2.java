class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s = new Stack<>();

        for (String token : tokens) {
            switch (token) {
                case "+":
                    s.push(s.pop() + s.pop());
                    break;

                case "-": {
                    int b = s.pop();
                    int a = s.pop();
                    s.push(a - b);
                    break;
                }

                case "*":
                    s.push(s.pop() * s.pop());
                    break;

                case "/": {
                    int b = s.pop();
                    int a = s.pop();
                    s.push(a / b);
                    break;
                }

                default:
                    s.push(Integer.parseInt(token));
            }
        }

        return s.pop();
    }
}