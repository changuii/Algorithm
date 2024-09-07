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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            
            sb.append("#").append(test).append(" ")
                .append(a % b == 0 ? 0 : 1);
            if(test != T) sb.append("\n");
            
        }
        System.out.println(sb);


        
    }
}