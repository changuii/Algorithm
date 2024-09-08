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
        for(int test=1; test<=T; test++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int val = (int)Math.pow(2, N)-1;
            
            sb.append("#").append(test).append(" ")
                .append((val & M) == val ? "ON" : "OFF");
            if(test != T) sb.append("\n");
            
        }
        System.out.println(sb);
    }

    
}