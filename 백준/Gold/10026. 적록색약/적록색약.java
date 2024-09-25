import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int N;
    static int c1 = 0;
    static int c2 = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
        }

        boolean[][] visit1 = new boolean[N][N];
        boolean[][] visit2 = new boolean[N][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(!visit1[i][j]){
                    BFS1(map, i, j, visit1);
                }
                if(!visit2[i][j]){
                    BFS2(map, i, j, visit2);
                }
            }
        }

        System.out.println(c1 + " " + c2);
    }

    public static void BFS1(char[][] map, int X, int Y, boolean[][] visit){
        Queue<int[]> q = new ArrayDeque<>();

        c1++;
        q.offer(new int[]{X, Y});
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >= 0 && x < N && y>=0 && y<N 
                  && !visit[x][y] && map[now[0]][now[1]] == map[x][y]){
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }
        
    }
    public static void BFS2(char[][] map, int X, int Y, boolean[][] visit){
        Queue<int[]> q = new ArrayDeque<>();

        c2++;
        q.offer(new int[]{X, Y});
        visit[X][Y] = true;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                // 빨강 - 초록을 구별 못함
                if(x >= 0 && x < N && y>=0 && y<N 
                  && !visit[x][y]){
                    if(map[now[0]][now[1]] == map[x][y]){
                        q.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                    else if((map[now[0]][now[1]] == 'R' && map[x][y] == 'G') 
                            || (map[now[0]][now[1]] == 'G' && map[x][y] == 'R')){
                        q.offer(new int[]{x, y});
                        visit[x][y] = true;
                    }
                }
            }
            
        }
        
    }
}