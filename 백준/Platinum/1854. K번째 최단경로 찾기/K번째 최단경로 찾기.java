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
       List<Edge>[] edges = new List[N];

       PriorityQueue<Integer>[] D = new PriorityQueue[N];
       for(int i=1; i<N; i++){
           // 크기를 K만큼 초기화, 내림차순 정렬
           D[i] = new PriorityQueue<>(K, (o1, o2) -> o2 - o1);
           edges[i] = new ArrayList<>();
       }

       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           int w = Integer.parseInt(st.nextToken());

           edges[a].add(new Edge(b, w));
       }

       PriorityQueue<Edge> q = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
       D[1].add(0);
       q.add(new Edge(1, 0));
       while (!q.isEmpty()){
           Edge now = q.poll();
           for(Edge x : edges[now.destination]){
               int next = x.destination;
               int distance = x.weight;
               if(D[next].size() < K){
                   // 현재 까지의 거리 + 다음 노드까지의 거리
                   D[next].add(now.weight + distance);
                   // q에 넣는다.
                   q.add(new Edge(next, now.weight + distance));
               }
               // 거리 큐가 가득 찼다면 (K개만큼의 거리가 밝혀졌다면)
               // 거리 큐의 상단 (내림차순)의 크기가 현재 까지의 거리 + 다음 노드까지의 거리보다 크다면, 갱신해준다.
               else if(D[next].peek() > now.weight + distance){
                   D[next].poll();
                   // 갱신한다.
                   D[next].add(now.weight + distance);
                   q.add(new Edge(next, now.weight + distance));
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