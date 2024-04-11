import java.util.*;
import java.math.*;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ");
        int min = Integer.parseInt(st.nextToken());
        int max = min;
        while(st.hasMoreTokens()){
            int now = Integer.parseInt(st.nextToken());
            min = Math.min(now, min);
            max = Math.max(now, max);
        }
        
        
        return min + " " + max;
    }
}