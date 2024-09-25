import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());

            int L = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            if(L == 0) break;
            int[] s = new int[3];
            int[] e = new int[3];
            

            char[][][] map = new char[L][R][C];
            for(int i=0; i<L; i++){
                for(int j=0; j<R; j++){
                    char[] val = br.readLine().toCharArray();
                    for(int k=0; k<C; k++){
                        map[i][j][k] = val[k];
                        if(map[i][j][k] == 'S'){
                            s = new int[]{i, j, k};
                        }
                        if(map[i][j][k] == 'E'){
                            e = new int[]{i, j, k};
                        }
                    }
                }
                br.readLine();
            }

            int answer = BFS(map, s, e, L, R, C);
            if(answer == -1){
                sb.append("Trapped!");
            }
            else{
                sb.append("Escaped in ").append(answer).append(" minute(s).");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS(char[][][] map, int[] s, int[] e, int L, int R, int C){
        Queue<int[]> q = new ArrayDeque<>();
        
        q.offer(new int[]{s[0], s[1], s[2], 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if(now[0] == e[0] && now[1] == e[1] && now[2] == e[2]) return now[3];
            for(int i=0; i<6; i++){
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                int z = now[2] + dz[i];
                if(!(x>= 0 && x<L && y >= 0 && y<R && z>=0 && z<C)) continue;

                if(map[x][y][z] == '.' || map[x][y][z] == 'E'){
                    map[x][y][z] = 'S';
                    q.offer(new int[]{x, y, z, now[3] + 1});
                }
                
            }
        }
        return -1;
        
    }
}