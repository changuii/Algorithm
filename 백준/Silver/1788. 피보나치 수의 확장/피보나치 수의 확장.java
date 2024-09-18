import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());


        // f[1] = 1 = f[0] + f[-1] = 0 + 1
        // f[0] = 0 = f[-2] + f[-1] = -1 + 1
        // f[-1] = 1 = f[-3] + f[-2] = -1 + 2
        // f[-2] = -1 = f[-4] + f[-3] = 2  -3
        // f[-3] = 2 = f[-4] + f[-5] = 2 -4
        // f[-1] = f[-2] + f[-3];
        // f[-1] - f[-2] = f[-3];

        if(N == 0){
            System.out.println(0 + "\n" + 0);
        }
        else if(N < 0){
            N = Math.abs(N);
            long[] nega = new long[N+1];

            // f[0] = f[-1] + f[-2];
            // f[i] = f[i-2] - f[i-1]  
            nega[0] = 0;
            nega[1] = 1;
            for(int i=2; i<nega.length; i++){
                nega[i] = (nega[i-2] - nega[i-1]) % 1_000_000_000;
            }
            // System.out.println(Arrays.toString(nega));
            System.out.println((nega[N] < 0 ? -1 : 1) + "\n" + Math.abs(nega[N]));
        }
        else{
            long[] posi = new long[N+1];

            posi[0] = 0;
            posi[1] = 1;
            for(int i=2; i<=N; i++){
                posi[i] = (posi[i-2] + posi[i-1]) % 1_000_000_000;
            }
            // System.out.println(Arrays.toString(posi));
            System.out.println(1 + "\n" + posi[N]);
         }
        
        

        
        
    }
}