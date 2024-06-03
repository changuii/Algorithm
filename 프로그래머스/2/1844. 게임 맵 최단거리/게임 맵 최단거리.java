import java.util.*;
class Solution {
    boolean[][] visit;
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    public int solution(int[][] maps) {
        visit = new boolean[maps.length][maps[0].length];
        BFS(maps);
        return maps[maps.length-1][maps[0].length-1] == 1 ? -1 : maps[maps.length-1][maps[0].length-1];
    }
    
    public void BFS(int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        
        visit[0][0] = true;
        q.add(new int[]{0, 0});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int valueX = now[0] + dx[i];
                int valueY = now[1] + dy[i];
                if(valueX >= 0 && valueY >= 0 && valueX <maps.length && valueY <maps[0].length){
                    if(maps[valueX][valueY] != 0 && !visit[valueX][valueY]) {
                        q.add(new int[]{valueX, valueY});
                        maps[valueX][valueY] += maps[now[0]][now[1]];
                        visit[valueX][valueY] = true;
                    }
                }
            }
            
        }
    }
}