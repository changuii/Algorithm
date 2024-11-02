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
            long x = Long.parseLong(br.readLine());

            while (x > 3) {
                x = x / 2 + 1;
                if(x <= 3) break;
                x = x / 2 - 1;
            }
            

            sb.append(String.format("#%d %s\n", t, x > 1 ? "Alice" : "Bob"));
        }

        System.out.println(sb);
        
    }
}