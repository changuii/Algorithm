import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] parent;
    static boolean[] V;
    static ArrayList<Integer>[] A;
    static int[] depth;
    static int k;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

       int N = Integer.parseInt(br.readLine());


       int count =1;
       k =0;
       while (count <= N){
           count <<= 1;
           k++;
       }

       parent = new int[k+1][N+1];
       V = new boolean[N+1];
       A = new ArrayList[N+1];
       depth = new int[N+1];
       for(int i=1; i<N+1; i++){
           A[i] = new ArrayList<>();
       }

       StringTokenizer st;
       for(int i=1; i<N; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a= Integer.parseInt(st.nextToken());
           int b= Integer.parseInt(st.nextToken());
           A[a].add(b);
           A[b].add(a);
       }

       BFS(1);

       for(int i = 1; i<k; i++){
           for(int j=1; j<N+1; j++){
               parent[i][j] = parent[i-1][parent[i-1][j]];
           }
       }

       int M = Integer.parseInt(br.readLine());
       StringBuilder sb = new StringBuilder();
       for(int i=0; i<M; i++){
           st = new StringTokenizer(br.readLine(), " ");
           int a = Integer.parseInt(st.nextToken());
           int b= Integer.parseInt(st.nextToken());
           sb.append(LCA(a, b)).append("\n");
       }
        System.out.println(sb);





    }


    public static void BFS(int a){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        V[a] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    q.add(x);
                    V[x] = true;
                    depth[x] = depth[now] + 1;
                    parent[0][x] = now;
                }
            }
        }
    }
    public static int LCA(int a, int b){
        if(depth[a] > depth[b]){
            int temp = b;
            b = a;
            a = temp;
        }
        int diff = depth[b] - depth[a];
        for(int i=k; i>=0; i--){
            if(diff >= Math.pow(2, i) && diff > 0){
                b = parent[i][b];
                diff = depth[b] - depth[a];
            }
        }

        if(a == b) return a;
        for(int i=k; i >= 0; i--){
            if(parent[i][a] != parent[i][b]){
                a = parent[i][a];
                b = parent[i][b];
            }
        }
        return parent[0][a];
    }

}