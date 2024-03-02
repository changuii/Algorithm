import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int INF = 10000001;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine(), " ");

       int N = Integer.parseInt(st.nextToken())+1;
       int M = Integer.parseInt(st.nextToken());
       int K = Integer.parseInt(st.nextToken());
       int[][] W = new int[1001][1001];

       PriorityQueue<Integer>[] D = new PriorityQueue[N];
       for(int i=1; i<N; i++){
           D[i] = new PriorityQueue<>(K, (o1, o2) -> o2 - o1);
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());

           W[a][b] = w;
       }

       PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
       D[1].add(0);
       q.add(new Edge(1, 0));
       while (!q.isEmpty()){
           Edge now = q.poll();
           for(int i =1; i<N; i++){
               if(W[now.destination][i] != 0){
                   if(D[i].size() < K){
                       D[i].add(now.weight + W[now.destination][i]);
                       q.add(new Edge(i, now.weight + W[now.destination][i]));
                   }
                   else if(D[i].peek() > now.weight + W[now.destination][i]){
                       D[i].poll();
                       D[i].add(now.weight + W[now.destination][i]);
                       q.add(new Edge(i, now.weight + W[now.destination][i]));
                   }
               }
           }
       }

       StringBuilder sb = new StringBuilder();
       for(int i=1; i<N; i++){
           if(D[i].size() == K) sb.append(D[i].peek()).append("\n");
           else sb.append("-1").append("\n");
       }
        System.out.println(sb);
    }
    static class Edge{
        int destination;
        int weight;
       public Edge(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }
}