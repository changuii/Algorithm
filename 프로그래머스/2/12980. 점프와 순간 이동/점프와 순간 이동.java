import java.util.*;

public class Solution {
    public int solution(int n) {
        
        // 6-> 3 -> (x) 2 -> 1 -> (x) 0
        // 5 -> (x) 4 -> 2 -> 1 -> (x) 0
        // 5000 -> 2500 -> 1250 -> 625 -> (x) 624 -> 312 -> 156 -> 78 -> 39
        // -> (x) 38 -> 19 -> (x) 18 -> 9 -> (x)8 -> 4 -> 2 -> 1 -> (x) 0
        int x = 0;
        for(int i=n; i>0;){
            if(i % 2 ==0) i = i / 2;
            else{
                x++;
                i = i-1;
            }
        }
        return x;
    }
}