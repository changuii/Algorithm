import java.util.*;
class Solution {
    boolean solution(String s) {
        char[] values = {'(', ')'};
        Deque<Character> q = new ArrayDeque<>();
        
        for(char c : s.toCharArray()){
            if(!q.isEmpty() && q.peekLast() == values[0] && c == values[1]){
                q.pollLast();
            }
            else{
                q.addLast(c);
            }
        }
        
        return q.isEmpty();
    }
}