import java.util.*;
class Solution {
    public int solution(String s) {
        
        String temp = lotate(s);
        int c = 0;
        while(!temp.equals(s)){
            if(isValid(temp)) c++;
            temp = lotate(temp);
        }
        if(isValid(s)) c++;
        return c;
    }
    
    public String lotate(String s){
        return s.substring(1, s.length()) + s.substring(0, 1);
    }
    
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char target = s.charAt(i);
            if(target == '{' || target == '[' || target == '(' ) stack.push(target);
            else{
                if(stack.isEmpty()) return false;
                char temp = stack.peek();
                if(target == '}' && temp == '{' ) stack.pop();
                else if(target == ']' && temp == '[' ) stack.pop();
                else if(target == ')' && temp == '(' ) stack.pop();
                else return false;
            }
        }
        return stack.isEmpty();
    }
}