import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken())+1;
        int E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        boolean[] visit = new boolean[V];
        int[] answer = new int[V];
        ArrayList<Node>[] A= new ArrayList[V];
        for(int i=1; i<V; i++){
            A[i] = new ArrayList<>();
            if(i == K) answer[i] = 0;
            else answer[i] = INF;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            A[a].add(new Node(b, w));
        }

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> {
            if(o1.w > o2.w) return 1;
            else return -1;
        });
        q.add(new Node(K, 0));
        while (!q.isEmpty()){
            Node now = q.poll();
            if(visit[now.b]) continue;
            visit[now.b] = true;
            for (Node x : A[now.b]){
                if(answer[x.b] > x.w + now.w) {
                    answer[x.b] = x.w + now.w;
                    q.add(new Node(x.b, x.w + now.w));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<V; i++){
            sb.append(visit[i] ? answer[i] : "INF").append("\n");
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