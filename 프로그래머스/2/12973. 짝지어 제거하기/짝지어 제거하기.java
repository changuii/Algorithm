import java.util.*;
class Solution
{
    public int solution(String s)
    {
        Deque<Character> q = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            if(!q.isEmpty() && q.peekLast() == s.charAt(i)){
                q.pollLast();
            } else{
                q.addLast(s.charAt(i));
            }
        }
        

        return q.isEmpty() ? 1 : 0;
    }
}