import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int[] binary;
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

      int N = Integer.parseInt(br.readLine());
      StringBuilder sb = new StringBuilder();

      for(int i=0; i<N; i++){
          StringTokenizer st = new StringTokenizer(br.readLine(), " ");

          int X = Integer.parseInt(st.nextToken())+1;
          int E = Integer.parseInt(st.nextToken());

          A = new ArrayList[X];
          V = new boolean[X];
          binary = new int[X];
          flag = false;
          for(int x=1; x<X; x++){
              A[x] = new ArrayList<>();
              binary[x] = 0;
          }

          for(int j=0; j<E; j++){
              st = new StringTokenizer(br.readLine());
              int a = Integer.parseInt(st.nextToken());
              int b = Integer.parseInt(st.nextToken());

              A[a].add(b);
              A[b].add(a);
          }

          for(int j=1; j<X; j++){
              BFS(j);
          }
          sb.append(flag ? "NO" : "YES").append("\n");

      }
      System.out.println(sb);

    }
    public static void BFS(int start){
        if(V[start]) return;
        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        V[start] = true;
        binary[start] = 1;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x] && binary[x] == 0){
                    q.add(x);
                    V[x] = true;
                    binary[x] = binary[now] * -1;
                }else if(V[x] && binary[x] == binary[now]) {
                    flag = true;
                    return;
                }
            }

        }


    }
}