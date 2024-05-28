import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        int[] value = new int[N];
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
            sum += value[i];
            max = Math.max(max, value[i]);
        }

        int M = Integer.parseInt(br.readLine());
        if(sum <= M){
            System.out.println(max);
            return;
        }

        Arrays.sort(value);
        max = M / N;
        for(int i=0; i<N; i++){
            if(value[i] < max){
                M= M-value[i];
                max = M / (N-i-1);
            }else{
                M = M - max;
            }
        }
        System.out.println(max);
        
        
    }
}