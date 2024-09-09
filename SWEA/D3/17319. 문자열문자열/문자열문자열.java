import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 1; t<=T; t++){
            sb.append("#").append(t).append(" ");
            
            int N = Integer.parseInt(br.readLine());
            String val = br.readLine();    
            String half = val.substring(0, N/2);
            sb.append(N%2==0 && val.equals(half + half) ? "Yes" : "No" ).append("\n");
        }
        System.out.println(sb);
    }

}