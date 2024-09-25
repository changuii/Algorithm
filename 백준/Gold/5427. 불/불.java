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

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int x = 0;
            int y = 0;

            ArrayList<int[]> fire = new ArrayList<>();
            int[][] map = new int[N][M];
            for(int i=0; i<N; i++){
                char[] val = br.readLine().toCharArray();
                for(int j=0; j<M; j++){
                    if(val[j] == '#')
                        map[i][j] = -1;
                    else if(val[j] == '*'){
                        map[i][j] = -2;
                        fire.add(new int[]{i, j});
                    }
                    else if(val[j] == '@'){
                        x = i;
                        y = j;
                    }
                }
            }
            
            // System.out.println("--------------------------------------------");
            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(map[i]));
            // }
            // System.out.println();
            int answer = BFS(map, N, M, x, y, fire);

            // for(int i=0; i<N; i++){
            //     System.out.println(Arrays.toString(map[i]));
            // }
            // System.out.println();
            sb.append(answer == -1 ? "IMPOSSIBLE" : answer+1).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(int[][] map, int N, int M, int X, int Y, ArrayList<int[]> fire){
        Queue<int[]> q = new ArrayDeque<>();

        for(int[] f : fire){
            q.offer(new int[]{f[0], f[1], 0});
        }
        q.offer(new int[]{X, Y, 1, 0});
        
        map[X][Y] =1;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[2] == 1 && (now[0] == 0 || now[0] == N-1 || now[1] == 0 || now[1] == M-1))
                return now[3];
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if(now[2] == 0 && x>=0 && x<N && y>=0 && y<M &&
                  map[x][y] >= 0){
                    map[x][y] = -2;
                    q.offer(new int[]{x, y, 0});
                }
                else if(now[2] == 1 && x>=0 && x<N && y>=0 && y<M &&
                  map[x][y] == 0){
                    map[x][y] = now[3] + 1;
                    q.offer(new int[]{x, y, 1, now[3] + 1});
                }
            }
        }
        return -1;
        
    }
}