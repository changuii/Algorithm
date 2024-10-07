import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 중심을 기준으로 열이 좌우 1칸씩 줄어듬
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){

            int N = Integer.parseInt(br.readLine());
            int mid = N / 2;

            int sum = 0;
            for(int i=0; i<N; i++){
                char[] val = br.readLine().toCharArray();

                // System.out.println(Math.abs(mid - i) + " ~ " +(N-Math.abs(mid - i)));
                for(int j=Math.abs(mid - i); j<N - Math.abs(mid - i); j++){
                    sum += val[j] - '0';
                }
                
            }

            sb.append("#").append(t).append(" ")
                .append(sum).append("\n");
            
        }
        System.out.println(sb);
    }
}