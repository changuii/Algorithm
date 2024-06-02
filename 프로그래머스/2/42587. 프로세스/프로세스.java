import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Queue<Node> q = new LinkedList<>();
        
        int th = 1;
        int[] value = new int[11];
        for(int i=0; i<priorities.length; i++){
            q.add(new Node(i , priorities[i]));
            value[priorities[i]]++;
        }
        
        while(true){
            Node now = q.poll();
            boolean flag = false;
            for(int i=now.value+1; i<value.length; i++){
                if(value[i] > 0){
                    flag = true;
                    break;
                }
            }
            if(flag){
                q.add(now);
                continue;
            }
            value[now.value]--;
            if(now.loc == location) return th;
            th++;
        }
    }
    
    public class Node{
        int loc;
        int value;
        public Node(int loc, int value){
            this.loc=loc;
            this.value=value;
        }
    }
}