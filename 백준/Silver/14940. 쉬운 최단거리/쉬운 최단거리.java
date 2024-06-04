import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] visit = new boolean[N][M];
        int[][] map = new int[N][M];
        int x = 0;
        int y = 0;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2){
                    x=i;
                    y=j;
                }
            }
        }
        int[][] answer = new int[N][M];
        BFS(map, answer, visit, x, y);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(answer[i][j] == 0 && 
                          map[i][j] == 1? -1 : answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        
        
    }
    public static void BFS(int[][] map, int[][] answer, boolean[][] visit, int x, int y){
        Queue<int[]> q = new LinkedList<>();

        visit[x][y] = true;
        q.add(new int[]{x, y});
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int xValue = now[0] + dx[i];
                int yValue = now[1] + dy[i];
                if(xValue >= 0 && yValue >= 0 && xValue < answer.length
                   && yValue < answer[0].length && !visit[xValue][yValue] 
                   && map[xValue][yValue] != 0){
                    answer[xValue][yValue] = answer[now[0]][now[1]] + 1;
                    visit[xValue][yValue] = true;
                    q.add(new int[]{xValue, yValue});
               }
            }
        }
    }
}