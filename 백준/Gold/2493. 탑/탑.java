import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        int[] value = new int[N+1];
        int[][] max = new int[N+1][2];
        value[0] = 100_000_001;
        for(int i=1; i<=N; i++){
            value[i] = Integer.parseInt(st.nextToken());
            if(value[i-1] >= value[i]){
                max[i][0] = value[i-1];
                max[i][1] = i-1;
            }else{
                int index = max[i-1][1];
                while(index >= 0){
                    if(value[index] >= value[i]){
                        max[i][0] = value[index];
                        max[i][1] = index;
                        break;
                    }
                    index = max[index][1];
                }
            }
        }
        for(int i=1; i<=N; i++){
            sb.append(max[i][1]).append(" ");
        }
        System.out.println(sb);
    }
}