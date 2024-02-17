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
    static int[] depth;
    static int K;
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");


        int N = Integer.parseInt(st.nextToken())+1;
        int M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        V = new boolean[N];
        A = new ArrayList[N];
        depth = new int[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            A[x].add(y);
        }

        BFS(X);
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<N; i++){
            if(depth[i] == K) sb.append(i).append("\n");
        }

        System.out.println(sb.length() < 1 ? -1 : sb);
    }

    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();

        depth[start] = 0;
        q.add(start);
        V[start] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    q.add(x);
                    V[x] = true;
                    depth[x] = depth[now] + 1;
                }
            }
            if(depth[now] > K) break;
        }


    }
}