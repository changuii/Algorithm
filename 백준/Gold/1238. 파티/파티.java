import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] g = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            g[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            g[a].add(new int[]{b, w});
        }

        
        int[][] Dist = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
                return o1[1] - o2[1];
            });
            boolean[] visit = new boolean[N+1];
            int[] D = new int[N+1];
            Arrays.fill(D, 10000000);
            D[i] = 0;
            q.add(new int[]{i, 0});

            while(!q.isEmpty()){
                int[] now = q.poll();

                if(visit[now[0]]) continue;
                visit[now[0]] = true;

                for(int[] v : g[now[0]]){
                    if(D[v[0]] > D[now[0]] + v[1]){
                        D[v[0]] = D[now[0]] + v[1];

                        q.add(new int[]{v[0], D[v[0]]});
                    }
                }
                
            }
            Dist[i] = D;
        }
        

        int max = 0;
        for(int i=1; i<=N; i++){
            if(i == X) continue;
            max = Math.max(max, Dist[i][X] + Dist[X][i]);
        }
        System.out.println(max);
        
        
    }
}