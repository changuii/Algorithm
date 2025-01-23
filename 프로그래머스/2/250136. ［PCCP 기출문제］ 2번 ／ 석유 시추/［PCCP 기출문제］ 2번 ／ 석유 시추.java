import java.util.*;
class Solution {
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    Map<Integer, Integer> map = new HashMap<>();
    public int solution(int[][] land) {
        int max = 0;
        init(land);
        
        for(int j=0; j<land[0].length; j++){
            boolean[] visit = new boolean[map.size() + 2];
            int c = 0;
            for(int i=0; i<land.length; i++){    
                if(land[i][j] > 0 && !visit[land[i][j]]){
                    visit[land[i][j]] = true;
                    c += map.get(land[i][j]);
                }
            }
            max = Math.max(max, c);
        }
        return max;
    }
    public void init(int[][] land){
        boolean[][] visit = new boolean[land.length][land[0].length];
        
        int idx = 2;
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[0].length; j++){
                if(!visit[i][j] && land[i][j] == 1){
                    int c = dfs(land, i, j, idx);
                    map.put(idx, c);
                    idx++;
                }
            }
        }
    }
    
    
    public int dfs(int[][] land, int x, int y, int mark){
        land[x][y] = mark;
        int c = 1;
        for(int i=0; i<4; i++){
            int X = x + dx[i];
            int Y = y + dy[i];
            
            if(!(X>=0 && X<land.length && Y>=0 && Y<land[0].length)) continue;
            
            if(land[X][Y] == 1){
                c += dfs(land, X, Y, mark);
            }
        }
        return c;
    }
}