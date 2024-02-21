import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());

        long[] distance = new long[N];
        Edge[] edges = new Edge[M+1];
        Arrays.fill(distance, INF);

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[i] = new Edge(a, b, w);
        }


        distance[1] = 0;
        for(int i=1; i<N-1; i++){
            for(int j=0; j<M; j++){
                Edge edge = edges[j];
                if(distance[edge.start] != INF && distance[edge.destination] > distance[edge.start] + edge.weight){
                    distance[edge.destination] = distance[edge.start] + edge.weight;
                }
            }
        }

        for(int j=0; j<M; j++){
            Edge edge = edges[j];
            if(distance[edge.start] != INF && distance[edge.destination] > distance[edge.start] + edge.weight){
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=2; i<N; i++){
            sb.append(distance[i] != INF ? distance[i] : -1).append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb);
    }


    static class Edge{
        int start;
        int destination;
        int weight;
        Edge(int start, int destination, int weight)
        {
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }
    }
}