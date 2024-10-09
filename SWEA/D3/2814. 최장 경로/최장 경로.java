import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            max = 0;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

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

            boolean[] visit = new boolean[N+1];
            for(int i=1; i<=N; i++){
                visit[i] = true;
                DFS(A, visit, i, 1);
                visit[i] = false;
            }
            
            sb.append(String.format("#%d %d\n", t, max));
        }
        System.out.println(sb);
    }

    public static void DFS(ArrayList<ArrayList<Integer>> A, boolean[] visit, int now, int depth){
        max = Math.max(max, depth);
        for(int next : A.get(now)){
            if(!visit[next]){
                visit[next] = true;
                DFS(A, visit, next, depth+1);
                visit[next] = false;
            }
        }
        
    }

    

    
}