import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Edge> edges = new ArrayList<>();
        long[] distance = new long[N];

        for(int i=0; i<N; i++){
            distance[i] = Long.MIN_VALUE;
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges.add(new Edge(a, b, w));
        }

        st = new StringTokenizer(br.readLine(), " ");
        long[] money = new long[N];
        for(int i=0; i<N; i++){
            money[i] = Long.parseLong(st.nextToken());
        }

        distance[S] = money[S];
        for(int i = 0; i<N + 100; i++){
            for(Edge x : edges){
                if(distance[x.start] == Long.MIN_VALUE) continue;
                else if (distance[x.start] == Long.MAX_VALUE) distance[x.destination] = Long.MAX_VALUE;
                else if (distance[x.destination] < distance[x.start] + money[x.destination] - x.weight){
                    distance[x.destination] = distance[x.start] + money[x.destination] - x.weight;
                    if( i > N-1) distance[x.destination] = Long.MAX_VALUE;
                }
            }
        }

        if(distance[D] == Long.MIN_VALUE) System.out.println("gg");
        else if(distance[D] == Long.MAX_VALUE) System.out.println("Gee");
        else System.out.println(distance[D]);
    }

    static class Edge{
        int start;
        int destination;
        int weight;
        public Edge(int start, int destination, int weight){
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }

    }
}