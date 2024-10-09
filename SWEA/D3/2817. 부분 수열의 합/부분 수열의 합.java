import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] A = new int[N];
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            
            sb.append("#").append(t).append(" ")
                .append(DFS(A, 0, new boolean[N], K, 0)).append("\n");
        }
        System.out.println(sb);
        
    }

    public static int DFS(int[] A, int now, boolean[] visit, int K, int sum){
        if(sum == K){
            return 1;
        }
        else{
            int val = 0;
            for(int i=now; i<A.length; i++){
                if(!visit[i]){
                    val+= DFS(A, i+1, visit, K, sum + A[i]);    
                }
            }
            return val;
        }
        
    }
}