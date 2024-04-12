import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        List<Integer> queue = new ArrayList<>();
        
        StringTokenizer st;
        for(String oper : operations){
            st = new StringTokenizer(oper, " ");
            String operation = st.nextToken();
            int value = Integer.parseInt(st.nextToken());
            if(operation.equals("I")){
                queue.add(value);
            }else if(operation.equals("D")){
                if(queue.size() < 1) continue;
                Collections.sort(queue);
                if(value == 1){
                    queue.remove(queue.size()-1);
                }else{
                    queue.remove(0);
                }
            }
            
        }
        int[] zero = {0, 0};
        if(queue.size() == 0) return zero;
        Collections.sort(queue);
        int[] answer = {queue.get(queue.size()-1), queue.get(0) };
        return answer;
    }
}