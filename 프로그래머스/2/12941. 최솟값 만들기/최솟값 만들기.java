import java.util.*;
class Solution{
    public int solution(int []A, int []B){
        
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });
        
        for(int i=0; i<A.length; i++){
            min.offer(A[i]);
            max.offer(B[i]);
        }
        
        int answer = 0;
        for(int i=0; i<A.length; i++){
            answer += min.poll() * max.poll();
        }
        
        

        return answer;
    }
}