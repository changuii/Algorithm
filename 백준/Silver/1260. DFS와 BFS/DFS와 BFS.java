import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    static ArrayList<Integer>[] A;
    static boolean[] V;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

       int N = Integer.parseInt(st.nextToken());
       int M = Integer.parseInt(st.nextToken());
       int S = Integer.parseInt(st.nextToken());

       V = new boolean[N+1];
       A = new ArrayList[N+1];
       for(int i=1; i<N+1; i++){
           A[i] = new ArrayList<>();
       }

       for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            A[x].add(y);
            A[y].add(x);
       }
       for(int i=1; i<N+1; i++){
           Collections.sort(A[i]);
       }

       DFS(S);
       sb.append("\n");
       V = new boolean[N+1];
       BFS(S);
       System.out.println(sb);


    }

    public static void DFS(int now){
        sb.append(now).append(" ");
        V[now] =true;
        for(int n : A[now]){
            if(!V[n]){
                DFS(n);
            }
        }
    }

    public static void BFS(int now){
        Queue<Integer> q = new LinkedList();

        q.add(now);
        V[now] = true;
        while (!q.isEmpty()){
            int a = q.poll();
            sb.append(a).append(" ");
            for(int x : A[a]){
                if(!V[x]){
                    V[x] = true;
                    q.add(x);
                }
            }
        }
    }

}

