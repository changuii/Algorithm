import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{prices[0], 0});
        
        int[] answer = new int[prices.length];
        for(int i=1; i<prices.length; i++){
            while(!stack.isEmpty()){
                if(stack.peek()[0] > prices[i]){
                    int[] now = stack.pop();
                    answer[now[1]] = i - now[1];
                }else break;
            }
            stack.push(new int[]{prices[i], i});
        }
        
        int size = prices.length-1;
        while(!stack.isEmpty()){
            int[] now = stack.pop();
            answer[now[1]] = size-now[1];
        }
        
        
        return answer;
    }
}