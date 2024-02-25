import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Edge> edges;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int V = Integer.parseInt(st.nextToken())+1;
        int E = Integer.parseInt(st.nextToken());

        edges = new ArrayList<>();
        A = new int[V];

        for(int i=1; i<V; i++){
            A[i] = i;
        }

        for(int i=0; i<E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.add(new Edge(start, destination, weight));
        }

        edges.sort((o1, o2) -> o1.weight - o2.weight);

        int answer = 0;
        for(Edge edge : edges){
            if(find(edge.start) != find(edge.destination)){
                union(edge.start, edge.destination);
                answer += edge.weight;
            }
        }

        System.out.println(answer);
    }

    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        A[y] = x;
    }
    public static int find(int a){
        if(A[a] == a) return a;
        else{
            A[a] = find(A[a]);
            return A[a];
        }
    }


    static class Edge{
        int start;
        int destination;
        int weight;

        Edge(int start, int destination, int weight){
            this.start = start;
            this.destination = destination;
            this.weight = weight;
        }
    }

}