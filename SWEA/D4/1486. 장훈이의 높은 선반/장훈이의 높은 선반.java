import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {

    static int min;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            st= new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;

            int[] A = new int[N];
            st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            DFS(A, new boolean[N], 0, 0, B);
            
            sb.append(String.format("#%d %d\n", t, min));
        }
        System.out.println(sb);
    }

    public static void DFS(int[] A, boolean[] visit, int now, int sum, int B){
        if(B <= sum){
            min = Math.min(min, sum - B);
            return;
        }

        for(int i=now; i<A.length; i++){
            if(!visit[i]){
                visit[i] = true;
                DFS(A, visit, i+1, sum + A[i], B);
                visit[i] = false;
            }
        }
        
    }
}