import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int index = citations.length-1;
        int i=1;
        int answer = 0;
        for(i=1; index>=0; i++){
            answer = Math.max(Math.min(i, citations[index]), answer);
            index--;
        }
        
        return answer;
    }
}