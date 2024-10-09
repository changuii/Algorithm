import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){

            br.readLine();
            int N = 100;

            int[][] A = new int[100][100];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<N; j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for(int i=0; i<N; i++){
                int sum1 = 0;
                int sum2 = 0;
                for(int j=0; j<N; j++){
                    sum1 += A[i][j];
                    sum2 += A[j][i];
                }
                answer = Math.max(answer, Math.max(sum1, sum2));
            }

            int sum1 =0;
            int sum2 =0;
            for(int i=0; i<N; i++){
                sum1 += A[i][i];
                sum2 += A[i][N-i-1];
            }
            answer = Math.max(answer, Math.max(sum1, sum2));


            sb.append("#").append(t).append(" ")
                .append(answer).append("\n");
        }
        System.out.println(sb);
        
    }
}