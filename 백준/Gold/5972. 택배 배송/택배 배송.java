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

        ArrayList<int[]>[] list = new ArrayList[N+1];
        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, w});
            list[b].add(new int[]{a, w});
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
            return o1[1] - o2[1];
        });

        boolean[] V = new boolean[N+1];
        int[] dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        q.add(new int[]{1, 0});
        while(!q.isEmpty()){
            int[] current = q.poll();
            if(V[current[0]]) continue;
            V[current[0]] = true;
            for(int[] a : list[current[0]]){
                if(!V[a[0]]){
                    dist[a[0]] = Math.min(dist[a[0]], current[1] + a[1]);
                    q.add(new int[]{a[0], dist[a[0]]});
                }
            }
        }
        System.out.println(dist[N]);
        
    }
}