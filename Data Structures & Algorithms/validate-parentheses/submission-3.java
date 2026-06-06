class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (c == '[')
                stack.push(']');
            else if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else{
                if (stack.isEmpty())
                    return false;
                
                if (c == stack.peek())
                    stack.pop();
                else
                    return false;
            }
                
        }
        return stack.isEmpty();
    }
}
