import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> A;
        StringTokenizer st;
        int N, M, X, S, G, H;
        int[] distance;
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
                return o1[1] - o2[1];
            });
        StringBuilder sb= new StringBuilder();
        int[] dest;
        for(int t=0; t<T; t++){
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            G = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            A = new ArrayList<>();
            for(int i=0; i<=N; i++){
                A.add(new ArrayList<>());
            }
            
            for(int i=0; i<M; i++){
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken()) * 2;
                if((a == G && b == H) || (a == H && b == G))
                    w--;
                
                A.get(a).add(new int[]{b, w});
                A.get(b).add(new int[]{a, w});
            }
            q.clear();

            distance = new int[N+1];
            Arrays.fill(distance, 1_000_000_000);
            distance[S] = 0;
            
            q.offer(new int[]{S, 0});
            while (!q.isEmpty()) {
                int[] now = q.poll();
                if(now[1] > distance[now[0]]) continue;
                for(int[] next : A.get(now[0])){
                    if(next[1] + now[1] < distance[next[0]]){
                        distance[next[0]] = next[1] + now[1];
                        q.offer(new int[]{next[0], next[1] + now[1]});
                    }
                }
            }

            // System.out.println(Arrays.toString(distance));
            dest = new int[X];
            for(int i=0; i<X; i++){
                dest[i] = Integer.parseInt(br.readLine());
            }

            Arrays.sort(dest);
            for(int destination : dest){
               if(distance[destination] % 2 == 1){
                   sb.append(destination).append(" ");
               }
            }

            // System.out.println(G + " " + H);
            // System.out.println(Arrays.toString(distance));
            // System.out.println(Arrays.toString(path));

            sb.append("\n");
        }
        System.out.println(sb);
        
        
        
        
    }
}