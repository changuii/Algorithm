import java.util.*;

public class Solution {
    public int solution(int n) {
        int c = 0;
        while(n >0){
            c += n % 2;
            n = n /2;
        }
        return c;
    }
}