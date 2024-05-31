import java.util.*;
class Solution {
    public int[] solution(int k, int[] score) {
        
        PriorityQueue<Integer> q = new PriorityQueue<>();
        
        int[] answer = new int[score.length];
        for(int i=0; i<score.length; i++){
            q.add(score[i]);
            if(q.size() > k) q.poll();
            answer[i] = q.peek();
        }   
        return answer;
    }
}