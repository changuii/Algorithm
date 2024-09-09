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
            int num = Integer.parseInt(br.readLine());
            
            sb.append("#").append(t).append(" ")
                .append((num*9) + " " + (num * 8)).append("\n");
        }
        System.out.println(sb);
    }

}