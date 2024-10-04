import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t =1; t<=T; t++){

            st = new StringTokenizer(br.readLine());
            StringBuilder s = new StringBuilder(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            DFS(s, 0, M);

            sb.append("#").append(t).append(" ")
                .append(max).append("\n");
            max = 0;
        }
        System.out.println(sb);
        
            
    }

    public static void DFS(StringBuilder sb, int K, int M){
        if(M == K){
            max = Math.max(max, Integer.parseInt(sb.toString()));
        }
        else{
            int x = (sb.length() - K) < 2 ? sb.length() - 2 : K; 
            for(int i=x; i<sb.length(); i++){
                for(int j=i+1; j<sb.length(); j++){
                    DFS(swap(sb, i, j), K+1, M);
                }
            }
        }
    }

    public static StringBuilder swap(StringBuilder sb, int i, int j){
        StringBuilder s = new StringBuilder(sb.toString());
        String temp = s.charAt(i) + "";
        s.replace(i, i+1, s.charAt(j) + "");
        s.replace(j, j+1, temp);
        return s;
    }
}