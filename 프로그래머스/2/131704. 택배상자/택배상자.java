import java.util.Stack;
class Solution {
    public int solution(int[] order) {
        
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        int index = 2;
        int count = 0;
        int now = 0;
        
        while(now < order.length){
            if(index < order[now]){
                stack.push(index++);
            }
            else if(index == order[now]){
                index++;
                now++;
                count++;
            }else if(!stack.isEmpty() && stack.peek() == order[now]){
                stack.pop();
                now++;
                count++;
            }else{
                break;
            }
            
        }
        
        
        return count;
    }
}