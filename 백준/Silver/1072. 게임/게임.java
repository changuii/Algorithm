import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long X = Integer.parseInt(st.nextToken());
        long Y = Integer.parseInt(st.nextToken());
        long percent = (Y * 100) / X;

        if(percent == 100){
            System.out.println(-1);
            return;
        }
        


        long l = 0;
        long h = 1_000_000_000;
        long mid = 0;

        while (l <= h) {
            mid = (l + h) / 2;

            if(check(X+mid, Y+mid, percent)){
                h = mid-1;
            }
            else{
                l = mid+1;
            }
        }

        long answer = h+1;
        if(check(X + answer, Y + answer, percent))
            System.out.println(answer);
        else System.out.println(-1);
        
    }

    public static boolean check(long X, long Y, long percent){
        long p = (Y * 100) / X;
        return p != percent;
    }
}