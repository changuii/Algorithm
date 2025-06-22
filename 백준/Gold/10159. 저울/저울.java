import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();
        for(int i=0; i<=N; i++){
            A.add(new ArrayList<>());
            B.add(new ArrayList<>());
        }
        
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A.get(a).add(b);
            B.get(b).add(a);
        }

        for(int i=1; i<=N; i++){
            int c = 0;
            boolean[] v = new boolean[N+1];
            boolean[] vv = new boolean[N+1];
            dfs(A, v, i);
            dfs(B, vv, i);
            for(int j=1; j<=N; j++){
                if(!v[j] && !vv[j]){
                    c++;
                }
            }

            sb.append(c).append("\n");
        }
        
        System.out.println(sb);
    }

    public static void dfs(ArrayList<ArrayList<Integer>> A, boolean[] v, int now){
        if(v[now]){
            return;
        }
        
        v[now] = true;
        
        for(int next : A.get(now)){
            dfs(A, v, next);
        }
    }
}