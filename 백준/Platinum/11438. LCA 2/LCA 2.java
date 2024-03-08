import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int[][] parents;
    static int[] depth;
    static int K;

    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine())+1;

       A = new ArrayList[N];
       V = new boolean[N];
       depth = new int[N];
       for(int i=1; i<N; i++){
           A[i] = new ArrayList<>();
       }

       StringTokenizer st;
       for(int i=1; i<N-1; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a= Integer.parseInt(st.nextToken());
           int b= Integer.parseInt(st.nextToken());

           A[a].add(b);
           A[b].add(a);
       }

       int temp = 1;
       K = 0;
       while (temp < N){
           temp <<= 1;
           K++;
       }

       parents = new int[K+1][N];
       BFS(1);

       for(int i=1; i<K; i++){
           for(int j=1; j< N; j++){
               parents[i][j] = parents[i-1][parents[i - 1][j]];
           }
       }

       int M = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           sb.append(LCA(a, b)).append("\n");
       }
        System.out.println(sb);

    }

    public static void BFS(int a){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        V[a] = true;
        depth[a] = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    q.add(x);
                    V[x] = true;
                    parents[0][x] = now;
                    depth[x] = depth[now]+1;
                }
            }

        }

    }

    public static int LCA(int a, int b){
        if(depth[a] > depth[b]){
            int temp = a;
            a = b;
            b = temp;
        }

        for(int i = K; i >= 0; i--){
            if(Math.pow(2, i) <= depth[b] - depth[a]){
                if(depth[a] <= depth[parents[i][b]]){
                    b = parents[i][b];
                }
            }
        }
        for(int i = K; i>= 0; i--){
            if(parents[i][a] != parents[i][b]){
                a = parents[i][a];
                b = parents[i][b];
            }
        }
        if(a != b)
            a = parents[0][a];
        return a;

    }


}