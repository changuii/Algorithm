import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static long[] dp = new long[60];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long a= Long.parseLong(st.nextToken());
        long b= Long.parseLong(st.nextToken());

        for(int i=1; i<dp.length; i++){
            dp[i] = (1L << (i-1)) + dp[i-1] * 2;
        }

        // for(int i=0; i<dp.length; i++){
        //     System.out.println(i + " " +dp[i]);
        // }
        
        System.out.println(func(b) - func(a-1));
    }

    public static long func(long x){
        if(x <= 0){
            return 0;
        }

        int num = -1;
        long y = x;
        while(y > 0){
            y = (y >> 1);
            num++;
        }
        
        long val = 1L << num;
        if(val == x){
            return dp[num] + 1;
        }

        long diff = x - val;
        return func(val) + diff + func(diff);
    }

}