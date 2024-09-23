import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        int[] B = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            B[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<R; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A.get(a).add(new int[]{b, w});
            A.get(b).add(new int[]{a, w});
        }

        int[][] distance = new int[N+1][N+1];
        for(int i=1; i<=N; i++){
            Arrays.fill(distance[i], Integer.MAX_VALUE);
            makeDistance(distance[i], i, A);
        }

        int max = 0;
        for(int i=1; i<=N; i++){

            int sum = 0;
            for(int j=1; j<=N; j++){
                if(distance[i][j] <= M){
                    sum += B[j];
                }
            }
            max = Math.max(max, sum);
            // System.out.println(Arrays.toString(distance[i]));
        }
        System.out.println(max);
        

        
    }

    public static void makeDistance(int[] distance, int start, ArrayList<ArrayList<int[]>> A){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
           return o1[1] - o2[1]; 
        });

        q.offer(new int[]{start, 0});
        distance[start] = 0;
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
        
    }
}