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
            int N = Integer.parseInt(br.readLine());

            StringBuilder answer = new StringBuilder();
            int now = 0;
            for(int i=0; i<N; i++){
                st = new StringTokenizer(br.readLine());

                String value = st.nextToken();
                int c = Integer.parseInt(st.nextToken());
                now = decryption(answer, value, c, now);
            }

            sb.append(String.format("#%d\n%s\n", t, answer.toString()));
        }
        System.out.println(sb);
    }

    public static int decryption(StringBuilder sb, String value, int c, int now){
        for(int i=0; i<c; i++){
            if(now == 10){
                sb.append("\n");
                now = 0;
            }
            sb.append(value);
            now++;
        }
        return now;
    }
}