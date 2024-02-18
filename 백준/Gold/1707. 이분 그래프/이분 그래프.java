import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


class Main {

    static ArrayList<Integer>[] A;
    static boolean[] visit;
    static boolean flag;
    static int[] binary;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int V = Integer.parseInt(st.nextToken()) + 1;
            int E = Integer.parseInt(st.nextToken());

            A = new ArrayList[V];
            visit = new boolean[V];
            binary = new int[V];
            flag = false;

            for(int j=1; j<V; j++){
                A[j] = new ArrayList<>();
                binary[j] = 0;
            }
            for(int j =0; j<E; j++){
                st = new StringTokenizer(br.readLine() , " ");

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                A[a].add(b);
                A[b].add(a);
            }

            for(int j=1; j<V; j++){
                if(!visit[j]){
                    BFS(j);
                }
            }
            sb.append(flag ? "NO" : "YES").append("\n");

        }
        System.out.println(sb);
    }


    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();

        binary[start] = 1;
        q.add(start);
        visit[start] = true;
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!visit[x] && binary[x] == 0) {
                    binary[x] = binary[now] * -1;
                    visit[x] = true;
                    q.add(x);
                }else if(visit[x] && binary[x] == binary[now]){
                    flag = true;
                    return;
                }
            }

        }

    }
}