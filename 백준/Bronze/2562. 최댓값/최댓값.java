import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = 9;

        int max = 0;
        int idx = 0;
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());

            if(now > max) {
                max = now;
                idx = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}