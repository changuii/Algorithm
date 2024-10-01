import java.util.*;
class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    int[] count;
    public int solution(int[][] land) {
        count = new int[250001 / 2];
        int now = 2;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(land[i][j] == 1){
                    BFS(land, i, j, now++);
                }
            }
        }
        
        // System.out.println(list);
        // System.out.println(Arrays.deepToString(land));
        
        boolean[] v = new boolean[250001 / 2];
        int max = 0;
        for(int i=0; i<land[0].length; i++){
            v = new boolean[250001 / 2];
            int c = 0;
            for(int j=0; j<land.length; j++){
                if(!v[land[j][i]] && land[j][i] > 1){
                    c += count[land[j][i]];
                    v[land[j][i]] = true;
                }
            }
            max = Math.max(c, max);
        }
        
        return max;
    }
    
    public void BFS(int[][] land, int X, int Y, int w){
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{X, Y});
        land[X][Y] = w;
        while(!q.isEmpty()){
            int[] now = q.poll();
            count[w]++;
            
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                
                if(!(x >=0 && x<land.length && y>=0 && y<land[0].length)) continue;
                
                if(land[x][y] == 1){
                    land[x][y] = w;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}