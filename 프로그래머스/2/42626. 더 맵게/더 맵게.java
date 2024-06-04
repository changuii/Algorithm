import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        for(int x : scoville){
            q.add(x);
        }
        
        int answer = 0;
        int x = q.poll();
        
        while(x < K){
            if(q.isEmpty()) return -1;
            int y= q.poll() * 2;
            q.add(x + y);
            x = q.poll();
            answer++;
        }
        return answer;
    }
}