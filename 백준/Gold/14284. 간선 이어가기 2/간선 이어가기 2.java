import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] set;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        set = new int[N+1];
        for(int i=1; i<=N; i++){
            set[i] = i;
        }
        
        ArrayList<ArrayList<int[]>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) ->{
           return o1[1] - o2[1]; 
        });

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A.get(a).add(new int[]{b, w});
            A.get(b).add(new int[]{a, w});
        }
        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] distance = new int[N+1];
        Arrays.fill(distance,  Integer.MAX_VALUE);
        q.offer(new int[]{x, 0});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(now[1] < distance[now[0]]){
                distance[now[0]] = now[1];

                for(int[] next : A.get(now[0])){
                    q.offer(new int[]{next[0], distance[now[0]] + next[1]});
                }
            }
        }
        
        System.out.println(distance[y]);
        

        
    }

}