import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken()+1);
        int M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());


        V = new boolean[N];
        A = new ArrayList[N];
        for(int i=1; i<N; i++){
            A[i] = new ArrayList<>();
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            A[x].add(y);
            A[y].add(x);
        }

        for(int i=1; i<N; i++){
            Collections.sort(A[i]);
        }

        sb = new StringBuilder();

        DFS(start);
        V = new boolean[N];
        sb.append("\n");
        BFS(start);
        System.out.println(sb);
    }

    private static void DFS(int index){
        if(V[index]) return ;

        sb.append(index).append(" ");
        V[index] = true;
        for(int x : A[index]){
            if(!V[x])
                DFS(x);
        }

    }

    private static void BFS(int index){
        Queue<Integer> q = new LinkedList<>();
        sb.append(index).append(" ");
        V[index] = true;
        q.offer(index);
        while (!q.isEmpty()){
            int now = q.poll();
            for(int x : A[now]){
                if(!V[x]){
                    sb.append(x).append(" ");
                    q.add(x);
                    V[x] = true;
                }
            }
        }
    }

}