import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            sb.append(String.format("#%d %d\n", t, max(N <= M ? A : B, N <= M ? B : A)));
        }

        System.out.println(sb);
    }

    public static int max(int[] A, int[] B) {

        int max = Integer.MIN_VALUE;
        for(int i=0; i<=B.length - A.length; i++) {
            int sum = 0;
            for(int j=0; j<A.length; j++) {
                sum += A[j] * B[j + i];
            }
            max = Math.max(sum, max);
        }
        return max;
    }
}