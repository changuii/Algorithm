import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static int[][] D;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine())+1;

        A = new ArrayList[N];
        D = new int[N][2];
        V = new boolean[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }


        StringTokenizer st;
        for(int i=1; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }
        BFS(1);


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
        D[a][1] = 0;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    V[x] = true;
                    q.add(x);
                    D[x][1] = D[now][1] + 1;
                    D[x][0] = now;
                }
            }
        }
    }

    public static int LCA(int a, int b){
        while (a != b){
            if(D[a][1] > D[b][1]){
                a = D[a][0];
            }else if(D[a][1] < D[b][1]){
                b = D[b][0];
            }else{
                a = D[a][0];
                b = D[b][0];
            }
        }
        return a;

    }
}