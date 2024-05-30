import java.util.Stack;
class Solution
{
    public int solution(String s)
    {
        Stack<Character> stack = new Stack<>();
        
        int i = 0;
        while(i < s.length()){
            if(stack.isEmpty()) stack.push(s.charAt(i));
            else{
                if(stack.peek() == s.charAt(i)) stack.pop();
                else stack.push(s.charAt(i));
            }
            i++;
        }
        
        
        return stack.isEmpty() ? 1 : 0;
    }
}