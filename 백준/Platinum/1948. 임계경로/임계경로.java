import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;
        int M = Integer.parseInt(br.readLine());

        int[] D = new int[N];
        List<Edge>[] edges = new List[N];
        List<Edge>[] reverseEdges = new List[N];
        for(int i=1; i<N; i++){
            reverseEdges[i] = new ArrayList<>();
            edges[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            edges[a].add(new Edge(b, w));
            reverseEdges[b].add(new Edge(a, w));
            D[b]++;
        }

        st = new StringTokenizer(br.readLine(), " ");
        int start = Integer.parseInt(st.nextToken());
        int destination = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        int[] result = new int[N];
        while (!q.isEmpty()){
            int now = q.poll();
            for(Edge next : edges[now]){
                D[next.destination]--;
                result[next.destination] = Math.max(result[next.destination], result[now] + next.weight);
                if(D[next.destination] == 0) q.offer(next.destination);
            }
        }

        int resultCount = 0;
        boolean visited[] = new boolean[N];
        q = new LinkedList<>();
        q.offer(destination);
        visited[destination] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(Edge next : reverseEdges[now]){
                if(result[next.destination] + next.weight == result[now]){
                    resultCount++;
                    if(!visited[next.destination]){
                        visited[next.destination] = true;
                        q.offer(next.destination);
                    }
                }
            }
        }
        System.out.println(result[destination]);
        System.out.println(resultCount);


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