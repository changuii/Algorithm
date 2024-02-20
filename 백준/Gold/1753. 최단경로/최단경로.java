import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;
    static int V;
    static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken())+1;
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        visit = new boolean[V];
        distance = new int[V];
        ArrayList<Node>[] A= new ArrayList[V];
        for(int i=1; i<V; i++){
            A[i] = new ArrayList<>();
            distance[i] = INF;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, w));
        }

       PriorityQueue<Node> q = new PriorityQueue<>((o1, o2)->{
           return o1.w - o2.w;
       });
        q.add(new Node(K, 0));
        distance[K] = 0;
        while (!q.isEmpty()){
            Node current = q.poll();
            int c_v = current.b;
            if(visit[c_v]) continue;
            visit[c_v] = true;
            for(int i=0; i<A[c_v].size(); i++){
                Node tmp = A[c_v].get(i);
                int next = tmp.b;
                int value = tmp.w;
                if(distance[next] > distance[c_v] + value){
                    distance[next] = value + distance[c_v];
                    q.add(new Node(next, distance[next]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V; i++){
            sb.append(visit[i] ? distance[i] : "INF").append("\n");
        }
        System.out.println(sb);


    }

    static class Node{
        int b;
        int w;

        Node(int b, int w){
            this.b=b;
            this.w=w;
        }
    }
}