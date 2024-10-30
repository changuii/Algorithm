import java.util.*;
class Solution {
    public int[] solution(int n) {
        int[] next = new int[n];
        int sum = 0;
        for(int i=0; i<n; i++){
            next[i] = n - i;
            sum += next[i];
        }
        
        int[] result = new int[sum];
        int index = 0;
        int direction = 0;
        int now = 0;
        int depth = 1;
        int num = 1;
        while(index < n){
            next[index]--;
            result[now] = num++;
            
            if(next[index] == 0){
                index++;
                direction = (direction + 1) % 3;
            }
            
            if(direction == 0){
                now = nextBottom(now, depth++);
            }
            else if(direction == 1){
                now = nextRight(now, depth);
            }
            else{
                now = nextTop(now, depth--);
            }
            
        }
        
        return result;
    }
    
    
    public int nextBottom(int now, int depth){
        return now + depth;
    }
    
    public int nextRight(int now, int depth){
        return now + 1;
    }
    
    public int nextTop(int now, int depth){
        return now - depth;
    }
}