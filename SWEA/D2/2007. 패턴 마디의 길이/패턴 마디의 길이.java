import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){

            int max = Integer.MAX_VALUE;
            int answer = 0;
            String now = br.readLine();
            for(int i=1; i<11; i++){
                String pattern = now.substring(0, i);
                if(now.replace(pattern, "").length() < max){
                    max = now.replace(pattern, "").length();
                    answer = i;
                }
                
            }
            
            sb.append(String.format("#%d %d\n", t, answer));
        }
        System.out.println(sb);
    }
}