import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        
        Queue<int[]> q = new LinkedList<>();
        
        int min = 1_000_000;
        q.add(new int[]{y, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            if(now[0] < x || min < now[1]){
                continue;
            }
            else if(now[0] == x){
                min = Math.min(min, now[1]);
                continue;
            }
            if(now[0] % 3 == 0) q.add(new int[]{now[0] / 3, now[1] + 1});
            if(now[0] % 2 == 0) q.add(new int[]{now[0] / 2, now[1] + 1});
            q.add(new int[]{now[0] - n, now[1]+1});
            
        }
        
        return min == 1_000_000 ? -1 : min;
    }
}