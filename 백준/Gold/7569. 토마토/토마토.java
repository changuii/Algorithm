import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N, M, H;
    static int[] dx = {0, 0, 1, -1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        int[][][] map = new int[N][M][H];
        ArrayList<int[]> tomatos = new ArrayList<>();
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j][k] = Integer.parseInt(st.nextToken());
                    if(map[i][j][k] == 1){
                        tomatos.add(new int[]{i, j, k});
                    }
                }
            }
        }
        // for(int k=0; k<H; k++){
        //     for(int i=0; i<N; i++){
        //         for(int j=0; j<M; j++){
        //             System.out.print(map[i][j][k] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        BFS(map, tomatos);
        // System.out.println();

        // for(int k=0; k<H; k++){
        //     for(int i=0; i<N; i++){
        //         for(int j=0; j<M; j++){
        //             System.out.print(map[i][j][k] + " ");
        //         }
        //         System.out.println();
        //     }
        // }

        int answer = 0;
        for(int k=0; k<H; k++){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    if(map[i][j][k] == 0){
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(map[i][j][k], answer);
                }
            }
        }
        System.out.println(answer-1);

        
        
    }

    public static void BFS(int[][][] map, ArrayList<int[]> tomatos){
        Queue<int[]> q = new ArrayDeque<>();

        boolean[][][] visit = new boolean[N][M][H];
        for(int[] tomato : tomatos){
            q.offer(new int[]{tomato[0], tomato[1], tomato[2]});
            visit[tomato[0]][tomato[1]][tomato[2]] = true;
        }
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for(int i=0; i<6; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int z = now[2] + dz[i];
                if(x>=0 && x<N && y >=0 && y<M && z>=0 && z < H &&
                  !visit[x][y][z] && map[x][y][z] == 0){
                    map[x][y][z] = map[now[0]][now[1]][now[2]] + 1;
                    visit[x][y][z] = true;
                    q.offer(new int[]{x, y, z});
                }
            }
        }
    }
}