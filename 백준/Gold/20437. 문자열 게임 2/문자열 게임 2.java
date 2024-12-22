import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++){
            char[] value = br.readLine().toCharArray();
            int K = Integer.parseInt(br.readLine());

            if(K == 1){
                sb.append("1 1\n");
                continue;
            }
            
            int[] c = new int[26];
            for(char v : value){
                c[v - 'a']++;
            }

            int min = 10_001;
            int max = 0;

            for(int i=0; i<value.length; i++){
                char now = value[i];
                if(c[now - 'a'] < K) continue;

                int count = 1;
                for(int j=i+1; j<value.length; j++){
                    if(value[j] == value[i]) count++;
                    if(count == K){
                        if(value[i] == value[j]) max = Math.max(max, j-i+1);
                        min = Math.min(min, j-i+1);
                        break;
                    }
                }
            }
            if(min == 10_001 || max == 0){
                sb.append("-1\n");
                continue;
            }
            sb.append(String.format("%d %d\n", min, max));
        }
        
        System.out.println(sb);
    }
}