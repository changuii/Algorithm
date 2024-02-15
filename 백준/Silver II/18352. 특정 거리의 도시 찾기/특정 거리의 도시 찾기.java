import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static List<Integer>[] A;
    static boolean[] V;
    static int K;
    static int N;
    static int[] depth;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine(), " ");

      N= Integer.parseInt(st.nextToken());
      int M = Integer.parseInt(st.nextToken());
      K = Integer.parseInt(st.nextToken());
      int X = Integer.parseInt(st.nextToken());

      depth = new int[N+1];
      A = new ArrayList[N+1];
      V = new boolean[N+1];
      for(int i=0; i<N+1; i++){
          A[i] = new ArrayList<>();
      }

      for(int i=0; i<M; i++){
          st = new StringTokenizer(br.readLine(), " ");
          int a = Integer.parseInt(st.nextToken());
          int b = Integer.parseInt(st.nextToken());
          A[a].add(b);
      }

      BFS(X);
      StringBuilder sb = new StringBuilder();
      for(int i = 1; i<N+1; i++){
          if(depth[i] == K) sb.append(i).append("\n");
      }

      System.out.println(sb.length() == 0 ? -1 : sb);




    }

    public static void BFS(int e){
        Queue<Integer> q = new LinkedList<>();

        q.add(e);
        V[e] = true;
        depth[e] = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            if(depth[now] > K) break;
            for(int x : A[now]){
                if(!V[x]){
                    depth[x] = depth[now] + 1;
                    q.add(x);
                    V[x] = true;
                }
            }
        }
    }


}