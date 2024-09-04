import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            char[] val = br.readLine().toCharArray();
            int count = 0;
            for(int j=0; j<val.length; j++){
                if('a' + j == val[j]) count++;
                else break;
            }
            
            sb.append("#" + i + " ")
                .append(count)
                .append("\n");
        }
        System.out.println(sb);
    }

    
}