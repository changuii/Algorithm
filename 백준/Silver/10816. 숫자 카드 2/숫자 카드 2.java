import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] plus = new int[10_000_001];
        int[] nega = new int[10_000_001];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0){
                plus[num]++;
            }
            else{
                nega[Math.abs(num)]++;
            }
        }

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num >= 0){
                sb.append(plus[num]);
            }
            else{
                sb.append(nega[Math.abs(num)]);
            }
            sb.append(" ");
        }
        System.out.println(sb);

        
        
    
    }
}