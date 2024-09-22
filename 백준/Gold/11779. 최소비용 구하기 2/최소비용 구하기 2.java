import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<int[]>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A.get(a).add(new int[]{b, w});
        }


        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        long[] distance = new long[N+1];
        Arrays.fill(distance, Long.MAX_VALUE);

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
           return Long.compare(o1[1], o2[1]); 
        });

        StringBuilder[] path = new StringBuilder[N+1];
        for(int i=1; i<=N; i++){
            path[i] = new StringBuilder();
        }
        q.add(new int[]{start, 0});
        distance[start] = 0;
        path[start].append(start + " ");
        while(!q.isEmpty()){
            int[] now = q.poll();
            if(now[1] > distance[now[0]]) continue;
            for(int[] next : A.get(now[0])){
                if(now[1] + next[1] < distance[next[0]]){
                    distance[next[0]] = now[1] + next[1];
                    q.offer(new int[]{next[0], now[1] + next[1]});
                    path[next[0]].setLength(0);
                    path[next[0]].append(path[now[0]]).append(next[0]).append(" ");
                }
            }
        }

        
        System.out.println(distance[end]);
        System.out.println(path[end].toString().split(" ").length);
        System.out.println(path[end]);
        
    }
}