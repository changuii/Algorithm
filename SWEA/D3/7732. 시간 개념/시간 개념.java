import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            String[] start = br.readLine().split(":");
            String[] end = br.readLine().split(":");

            int s = Integer.parseInt(start[0]) * 3600 + Integer.parseInt(start[1]) * 60 + Integer.parseInt(start[2]);
            int e = (Integer.parseInt(end[0]) * 3600 + Integer.parseInt(end[1]) * 60 + Integer.parseInt(end[2])) - s;
            
            if(e < 0) e += 3600 * 23 + 60 * 59 + 60;
            
            sb.append("#" + i + " ")
                .append(String.format("%02d:", e/3600) + String.format("%02d:", e%3600/60) + String.format("%02d", e%3600%60))
                .append("\n");
        }
        System.out.println(sb);
    }

    
}