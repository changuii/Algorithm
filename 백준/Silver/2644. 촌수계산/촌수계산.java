import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int find = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());

        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A.get(a).add(b);
            A.get(b).add(a);
        }
        DFS(A, X, Y, new boolean[N+1], 0);
        System.out.println(find);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> A, int now, int Y, boolean[] visit, int depth){
        if(find != -1) return;
        if(now == Y){
            find = depth;
            return;
        }
        
        for(int next : A.get(now)){
            if(!visit[next]){
                visit[next] = true;
                DFS(A, next, Y, visit, depth+1);
            }
        }
    }
}