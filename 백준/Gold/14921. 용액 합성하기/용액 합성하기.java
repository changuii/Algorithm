import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            
            A[i] = Integer.parseInt(st.nextToken());
        }

        int l = 0;
        int h = N-1;
        int min = 300_000_000;
        int answer = 0;
        while (l<h) {
            int val = A[l] + A[h];

            if(min > Math.abs(val)){
                answer = val;
                min = Math.abs(val);
            }

            if(val <= 0){
                l++;
            }
            else{
                h--;
            }
            
        }
        System.out.println(answer);
    }
}