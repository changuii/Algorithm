import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());


        StringBuilder sb= new StringBuilder();
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<int[]>> A = new ArrayList<>();
            for(int i=0; i<=N; i++){
                A.add(new ArrayList<>());
            }

            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                A.get(b).add(new int[]{a, w});
            }

            PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
                return o1[1] - o2[1];
            });

            int[] distance = new int[N+1];
            Arrays.fill(distance, Integer.MAX_VALUE);
            
            q.offer(new int[]{C, 0});
            distance[C] = 0;

            while (!q.isEmpty()) {
                int[] now = q.poll();
                if(now[1] > distance[now[0]]) continue;
                for(int[] next : A.get(now[0])){
                    if(now[1] + next[1] < distance[next[0]]){
                        distance[next[0]] = now[1] + next[1];
                        q.offer(new int[]{next[0], now[1] + next[1]});
                    }
                }
            }

            int max = 0;
            int count = 0;
            for(int x : distance){
                if(x == Integer.MAX_VALUE) continue;
                max = Math.max(x, max);
                count++;
            }
            // System.out.println(Arrays.toString(distance));

            sb.append(count).append(" ").append(max)
                .append("\n");
        }
        System.out.println(sb);
        
        
        
        
    }
}