import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int divide = 100_000_000;
        while(n > 0){
            answer += n / divide;
            n = n % divide;
            divide = divide/10;
        }

        return answer;
    }
}