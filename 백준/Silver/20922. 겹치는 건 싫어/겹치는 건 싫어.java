import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] value = new int[N];
        int m = 0;
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            value[i] = Integer.parseInt(st.nextToken());
            m = Math.max(m, value[i]);
        }

        int max = 0;
        int i=0; 
        int j=0;
        int[] count = new int[m+1];
        while(j<N && i<N){
            count[value[j++]]++;
            while(count[value[j-1]] > K){
                count[value[i]]--;
                i++;
            }
            max = Math.max(max, j-i);
        }
        System.out.println(max);
        
        
    }
}