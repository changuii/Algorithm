import java.util.*;
class Solution {
    char[] val = {'{', '}', '[', ']', '(', ')'};
    public int solution(String s) {
        
        StringBuilder sb = new StringBuilder(s);
        int answer = 0;
        for(int i=0; i<s.length()-1; i++){
            if(isCorrect(sb)) answer++;
            sb.insert(sb.length(), sb.charAt(0));
            sb.delete(0, 1);
        }
        
        return answer;
    }
    
    public boolean isCorrect(StringBuilder sb){
        Deque<Character> q = new ArrayDeque<>();
        
        for(int i=0; i<sb.length(); i++){
            if(!q.isEmpty() && isMatch(q.peekLast(), sb.charAt(i))){
                q.pollLast();
            } else{
                q.addLast(sb.charAt(i));
            }
        }
        return q.isEmpty();
    }
    
    public boolean isMatch(char a, char b){
        for(int i=0; i<3; i++){
            if(val[i * 2] == a && val[i * 2 + 1] == b){
                return true;
            }
        }
        return false;
    }
}