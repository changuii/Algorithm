import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb=  new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            
            int[][] map = new int[N][M];
            boolean[][] visit = new boolean[N][M];

            ArrayList<int[]> A = new ArrayList<>();
            for(int i=0; i<K; i++){
                st = new StringTokenizer(br.readLine());
                int a=Integer.parseInt(st.nextToken());
                int b=Integer.parseInt(st.nextToken());

                map[a][b] = 1;
                A.add(new int[]{a, b});
            }
            int answer = 0;
            for(int[] now : A){
                if(!visit[now[0]][now[1]]){
                    answer++;
                    BFS(map, visit, N, M, now[0], now[1]);
                }
            } 

            sb.append(answer).append("\n");
            
            
        }
        System.out.println(sb);
    }


    public static void BFS(int[][] map, boolean[][] visit, int N, int M, int X, int Y){
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{X, Y});
        visit[X][Y] = true;
        while(!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x>=0 && x<N && y>=0 && y<M && !visit[x][y] && map[x][y] != 0){
                    q.offer(new int[]{x, y});
                    visit[x][y] = true;
                }
            }
        }
        
    }
}