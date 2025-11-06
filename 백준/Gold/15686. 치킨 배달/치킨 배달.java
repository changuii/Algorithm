import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int Z;
    static int answer;
    static boolean[] visit;
    static List<int[]> c;
    static List<int[]> h;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        c = new ArrayList<>();
        h = new ArrayList<>();
        
        int[][] map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] == 0) continue;

                if(map[i][j] == 1) {
                    h.add(new int[]{i, j});
                }
                else if(map[i][j] == 2) {
                    c.add(new int[]{i, j});
                }
            }
        }

        visit = new boolean[c.size()];
        Z = c.size() - M;
        answer = Integer.MAX_VALUE;

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int depth, int start) {
        if(depth == Z) {
            answer = Math.min(answer, calculate());
            return;
        }

        for(int i=start; i<visit.length; i++) {
            if(!visit[i]) {
                visit[i] = true;
                dfs(depth + 1, i+1);
                visit[i] = false;
            }
        }
    }

    public static int calculate() {
        int sum = 0;
        
        for(int i=0; i<h.size(); i++) {
            int dis = Integer.MAX_VALUE;
            int[] now = h.get(i);
            for(int j=0; j<c.size(); j++) {
                if(visit[j]) continue;

                int[] nowc = c.get(j);
                
                dis = Math.min(dis, Math.abs(now[0] - nowc[0]) + Math.abs(now[1] - nowc[1]));
            }
            sum += dis;
            if(sum >= answer) return sum;
        }
        return sum;
    }
}