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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        ArrayList<ArrayList<int[]>> list = new ArrayList<>();

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st=new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list.get(a).add(new int[]{b, w});
            list.get(b).add(new int[]{a, w});
        }

        long[][] distanceB = dijkstra(list, B, N);
        if(distanceB[A][0] == Long.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        long[][] distanceA = dijkstra(list, A, N);


        long[][] distance = new long[N+1][2];
        long shame = 1_000_000_000L;
        for(int i=1; i<N; i++){
            distance[i][0] = distanceA[i][0] + distanceB[i][0];
            distance[i][1] = Math.max(distanceA[i][1], distanceB[i][1]);

            if(distance[i][0] <= C && shame > distance[i][1]){
                shame = distance[i][1];
            }
        }

        if(shame == 1_000_000_000L){
            System.out.println(-1);
            return;
        }
        System.out.println(shame);
        
    }
    
    public static long[][] dijkstra(ArrayList<ArrayList<int[]>> list, int start, int N){
        
        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) ->{
           return Long.compare(o1.weight, o2.weight); 
        });

        boolean[] visit = new boolean[N+1];
        
        long[][] distance= new long[N+1][2];
        for(int i=1; i<=N; i++){
            distance[i][0] = Long.MAX_VALUE;
        }
        
        q.offer(new Node(start, 0));
        distance[start][0] = 0;
        while (!q.isEmpty()) {
            Node now = q.poll();

            if(visit[now.index]) continue;
            visit[now.index] = true;
            
            for(int[] next : list.get(now.index)){
                if(next[1] + now.weight < distance[next[0]][0]){
                    distance[next[0]][0] = now.weight + next[1];
                    distance[next[0]][1] = Math.max(distance[now.index][1], next[1]);
                    q.offer(new Node(next[0], distance[next[0]][0]));
                }
            }
        }

        return distance;
    }

    public static class Node{
        int index;
        long weight;

        public Node(int index, long weight){
            this.index=index;
            this.weight=weight;
        }

        public String toString(){
            return String.format("[ %d, %d ]", index, weight);
        }
    }

}