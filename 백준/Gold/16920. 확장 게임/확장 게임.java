import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int N, M, P;
    static int[] K;
    static int[] answer;
    static boolean flag = true;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        int[] K = new int[P+1];
        Queue<int[]>[] q = new Queue[P+1];
        answer = new int[P+1];
        
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=P; i++){
            K[i] = Integer.parseInt(st.nextToken());
            q[i] = new ArrayDeque<>();
           
        }


        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            char[] val = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(val[j] == '#') map[i][j] = -1;
                else if(val[j] == '.') continue; 
                else{
                    map[i][j] = val[j] - '0';    
                    q[map[i][j]].offer(new int[]{i, j, map[i][j], 1});
                }
            }
        }

        while (flag) {
            flag = false;

            for(int i=1; i<=P; i++){
                q[i] = BFS(map, K, q[i]);
                
            }
        }
        
        // for(int i=0; i<N; i++){
        //     System.out.println(Arrays.toString(map[i]));
        // }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=P; i++){
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb);
        
    }

    public static Queue<int[]> BFS(int[][] map, int[] K, Queue<int[]> q){
        Queue<int[]> temp = new ArrayDeque<>();
        while (!q.isEmpty()) {
            int[] now = q.poll();

            // System.out.println();
            // if(now[2] == 2){
            //      System.out.println(now[0] + " " + now[1]);    
            // }
            
            
            answer[now[2]]++;         
            for(int i=0; i<4; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];

                if(!(x >=0 && x<N && y>=0 && y<M)) continue;

                if(map[x][y] == 0 && now[3] != K[now[2]]){
                    flag = true;
                    q.offer(new int[]{x, y, now[2], now[3] + 1});
                    map[x][y] = now[2];
                    // System.out.println("1 : "+x + " " + y);
                }
                else if(map[x][y] == 0 && now[3] == K[now[2]]){
                    flag = true;
                    temp.offer(new int[]{x, y, now[2], 1});
                    map[x][y] = now[2];
                    // System.out.println("2 : "+x + " " + y);
                }
            }
        }
        return temp;
    }
}