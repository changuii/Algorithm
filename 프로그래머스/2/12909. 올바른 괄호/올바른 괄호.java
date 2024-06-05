import java.util.*;
class Solution {
    boolean solution(String s) {
        int c = 0;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '(') c++;
            else c--;
            
            if(c < 0) return false;
        }
        return c == 0;
    }
}