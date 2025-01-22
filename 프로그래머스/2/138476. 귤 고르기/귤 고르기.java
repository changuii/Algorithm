import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        
        int[] count = new int[10_000_001];
        for(int i=0; i<tangerine.length; i++){
            count[tangerine[i]]++;
        }
        
        Arrays.sort(count);
        
        int answer = 0;
        for(int i=count.length-1; i>0; i--){
            k -= count[i];
            answer++;
            if(k <= 0) return answer;
        }   
        
        return answer;
    }
}