import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[answer.length-1] = -1;
        for(int i=numbers.length-2; i>=0; i--){
            int now = numbers[i];
            boolean flag = false;
            for(int j=i+1; j<numbers.length; j++){
                if(now < numbers[j]){
                    answer[i] = numbers[j];
                    flag = true;
                    break;
                }else if(now >= numbers[j] && answer[j] > now){
                    answer[i] = answer[j];
                    flag = true;
                    break;
                }else if(now >= numbers[j] && answer[j] == -1){
                    answer[i] = answer[j];
                    flag = true;
                    break;
                }
            }
            if(!flag) answer[i] = -1;
        }
        
        
        return answer;
    }
}