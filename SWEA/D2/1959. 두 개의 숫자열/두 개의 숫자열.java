import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            int[] B = new int[M];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            int size = N < M ? N : M;
            int start = 0;
            while((N < M ? M : N) - size >= start){
                if(N < M){
                    answer = Math.max(sum(A, B, start, start + size - 1), answer);
                }
                else{
                    answer = Math.max(sum(B, A, start, start + size - 1), answer);
                }
                start++;
            }
            
            sb.append(String.format("#%d %d\n", t, answer));            
        }
        System.out.println(sb);
    }

    public static int sum(int[] A, int[] B, int start, int end){
        int sum = 0;
        int index = 0;
        for(int i=start; i<=end; i++){
            sum += A[index++] * B[i];
        }
        return sum;
    }
}