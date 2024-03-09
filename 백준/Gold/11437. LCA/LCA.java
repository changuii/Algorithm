import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static int[][] D;
    static boolean[] V;
    static ArrayList<Integer>[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        V = new boolean[N];
        D = new int[2][N];
        A = new ArrayList[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1; i<N-1; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }
        BFS(1);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a= Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a, b)).append("\n");
        }
        System.out.println(sb);

    }

    static void BFS(int a){
        Queue<Integer> q = new LinkedList<>();

        q.add(a);
        V[a] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    q.add(x);
                    V[x] = true;
                    D[0][x] = now;
                    D[1][x] = D[1][now] +1;
                }
            }
        }
    }

    public static int LCA(int a, int b){
        if(D[1][a] > D[1][b]){
            int temp = b;
            b = a;
            a = temp;
        }
        while (D[1][a] != D[1][b]){
            b = D[0][b];
        }
        while (a != b){
            a = D[0][a];
            b = D[0][b];
        }
        return a;
    }
}