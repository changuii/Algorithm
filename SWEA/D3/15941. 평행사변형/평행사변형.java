import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=N; i++){
            int a = Integer.parseInt(br.readLine());
            
            sb.append("#" + i + " ")
                .append(a * a)
                .append("\n");
        }
        System.out.println(sb);
    }
}