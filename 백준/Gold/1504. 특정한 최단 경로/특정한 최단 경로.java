import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());;

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            A.get(a).add(new int[]{b, c});
            A.get(b).add(new int[]{a, c});
        }

        st = new StringTokenizer(br.readLine());
        int s1 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        int MAX = 1_000_000_000;
        long[] dis1 = new long[N+1];
        long[] dis2 = new long[N+1];
        Arrays.fill(dis1, MAX);
        Arrays.fill(dis2, MAX);

        makeDistance(dis1, A, s1);
        makeDistance(dis2, A, s2);

        // v1 = 1일 수 있음
        // v2 = N일 수 있음
        // 1 -> o1 -> o2 -> N
        // 1 -> o2 -> o1 -> N
        // 1 -> N
        // 1 -> o2 -> N
        long val1 = dis1[1] + dis1[s2] + dis2[N];
        long val2 = dis2[1] + dis2[s1] + dis1[N];
        // if(s1 == 1){
        //     val2 = dis2[1] + dis2[N];
        // }
        // else if(s2 == N){
        //     val2 = dis1[s2] + dis1[1];
        // }
        if(val1 >= MAX && val2 >= MAX){
            System.out.println(-1);
            return;
        }
        
        System.out.println( val1 < val2 ? val1 : val2);
        
    }

    public static void makeDistance(long[] distance, ArrayList<ArrayList<int[]>> A, int start){
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
           return o1[1] - o2[1]; 
        });

        q.add(new int[]{start, 0});
        distance[start] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[1] > distance[now[0]]) continue;
            for(int[] next : A.get(now[0])){
                if(now[1] + next[1] <= distance[next[0]]){
                    distance[next[0]] = now[1] + next[1];
                    q.offer(new int[]{next[0], now[1] + next[1]});
                }
            }
        }

        
    }
}