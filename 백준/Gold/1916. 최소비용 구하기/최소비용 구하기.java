import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine())+1;
      int M = Integer.parseInt(br.readLine());

      ArrayList<Bus>[] A = new ArrayList[N];
      boolean[] V = new boolean[N];
      int[] distance = new int[N];
      for(int i=1; i<N; i++){
          A[i] = new ArrayList<>();
          distance[i] = INF;
      }

      StringTokenizer st;
      for(int i=0; i<M; i++){
          st = new StringTokenizer(br.readLine(), " ");
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          int w = Integer.parseInt(st.nextToken());

          A[a].add(new Bus(b, w));
      }
      st = new StringTokenizer(br.readLine(), " ");
      int S = Integer.parseInt(st.nextToken());
      int D = Integer.parseInt(st.nextToken());

      PriorityQueue<Bus> q = new PriorityQueue<>((o1, o2) -> {
          return o1.weight - o2.weight;
      });
      q.add(new Bus(S, 0));
      distance[S] = 0;
      while (!q.isEmpty()){
          Bus now = q.poll();
          if(V[now.destination]) continue;
          V[now.destination] = true;

          for(Bus x : A[now.destination]){
              if(distance[x.destination] > distance[now.destination] + x.weight){
                  distance[x.destination] = distance[now.destination] + x.weight;
                  q.add(new Bus(x.destination, distance[x.destination]));
              }
          }
      }
        System.out.println(distance[D]);


    }

    static class Bus{
        int destination;
        int weight;
        Bus(int destination, int weight){
            this.destination = destination;
            this.weight = weight;
        }
    }
}