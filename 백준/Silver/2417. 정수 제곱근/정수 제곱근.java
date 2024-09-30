import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double N = Double.parseDouble(br.readLine());
        long l = 0;
        long h = (long)N;
        long mid = 0;
        // System.out.println(N);

        while (l <= h) {
            mid = (l + h) / 2;

            double val = Math.pow(mid, 2);
            // System.out.println("==============");
            // System.out.println(l + " " + h);
            // System.out.println("mid : " + mid);
            // System.out.println("val : " + val);
            // System.out.println("flag : " + (val < N));
            if(val < N){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        System.out.println(l);
        
        
        
    }
}