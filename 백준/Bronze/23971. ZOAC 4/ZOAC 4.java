import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int countH = 0;
        int temp = H;
        while(temp > 0){
            countH++;
            temp -= (1 + N);
        }

        int countW = 0;
        temp = W;
        while(temp > 0){
            countW++;
            temp -= (1 + M);
        }
        System.out.println(countH * countW);
    }
}