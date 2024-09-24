import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visit;
    static int N, M;
    static int c = 0;
    static int block = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        visit = new boolean[N][M];

        ArrayList<int[]> tomatos = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1){
                    tomatos.add(new int[]{i, j});
                }
            }
        }
        BFS(map, tomatos);
        int answer = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                else{
                    answer = Math.max(answer, map[i][j]);
                }
            }
        }
        
        
        System.out.println(answer-1);

        
    }

    public static void BFS(int[][] map, ArrayList<int[]> tomatos){
        Queue<int[]> q = new ArrayDeque<>();

        for(int[] tomato : tomatos){
            q.offer(new int[]{tomato[0], tomato[1]});
        }
        while (!q.isEmpty()){
            int[] now = q.poll();
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(x >=0 && x<N && y>=0 && y<M && map[x][y] == 0){
                    map[x][y] = map[now[0]][now[1]] + 1;
                    q.offer(new int[]{x, y});
                }
            }
            
        }
        

        
    }
}