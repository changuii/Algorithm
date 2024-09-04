import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isTrue = new boolean[101];

        for(int i=1; i<=9; i++){
            for(int j=1; j<=9; j++){
                isTrue[i * j] = true;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int now = Integer.parseInt(br.readLine());
            
            sb.append("#" + i + " ")
                .append(isTrue[now] ? "Yes" : "No")
                .append("\n");
        }
        System.out.println(sb);
    }

    
}