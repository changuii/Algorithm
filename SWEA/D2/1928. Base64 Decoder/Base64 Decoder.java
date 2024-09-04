import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            sb.append("#" + i + " ")
                .append(new String(Base64.getDecoder().decode(br.readLine())))
                .append("\n");
        }
        System.out.println(sb);
    }

    
}