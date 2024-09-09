import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            String[] A = new String[N];
            String[] B = new String[M];

            st= new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = st.nextToken();
            }

            int X = Integer.parseInt(br.readLine());
            sb.append("#").append(t).append(" ");
            for(int i=0; i<X; i++){
                int now = Integer.parseInt(br.readLine());
                sb.append(A[(now-1) % N]).append(B[(now-1) % M]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}