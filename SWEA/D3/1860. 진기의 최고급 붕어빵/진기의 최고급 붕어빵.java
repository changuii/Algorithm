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

        for(int t=1;t<=T; t++){

            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(st.nextToken());
            }

            int index = 0;
            int c = 0;
            boolean flag = true;
            Arrays.sort(A);
            while (index < N) {
                
                int brade = (A[index++] / M ) * K - c;

                if(brade == 0) {
                    flag = false;
                    break;
                }
                    
                c++;
            }
            
            sb.append(String.format("#%d %s\n", t, flag ? "Possible" : "Impossible"));
        }
        System.out.println(sb);
    }
}