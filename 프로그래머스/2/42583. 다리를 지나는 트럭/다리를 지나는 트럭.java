import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        
        int time = 0;
        int c = 0;
        int i = 0;
        int bridgeWeight = 0;
        Deque<int[]> q = new ArrayDeque<>();
        while(c < truck_weights.length){
            if(!q.isEmpty() && time - q.peek()[1] == bridge_length){
                int[] val = q.pop();
                bridgeWeight -= val[0];
                c++;
            }
            if(i < truck_weights.length && bridgeWeight + truck_weights[i] <= weight){
                q.addLast(new int[]{truck_weights[i], time});
                bridgeWeight += truck_weights[i++];
            }
            time++;
        }
        return time;
    }
}