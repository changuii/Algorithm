import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.stream.Collectors;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[][] A = new int[N][2];

            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());
                A[i][0] = Integer.parseInt(st.nextToken());
                A[i][1] = Integer.parseInt(st.nextToken());
            }

            int P = Integer.parseInt(br.readLine());
            int[][] S = new int[P][2];

            for(int i=0; i<P; i++){
                S[i][0] = Integer.parseInt(br.readLine());
            }

            for(int i=0; i<N; i++){
                for(int j=0; j<P; j++){
                    if(S[j][0] >= A[i][0] && S[j][0] <= A[i][1]){
                        S[j][1]++;
                    }
                }
            }

            StringBuilder answer = new StringBuilder();
            for(int i=0; i<P; i++){
                answer.append(S[i][1]).append(" ");
            }
            

            sb.append(String.format("#%d %s\n", t, answer.toString()));
        }
        System.out.println(sb);
    }
}