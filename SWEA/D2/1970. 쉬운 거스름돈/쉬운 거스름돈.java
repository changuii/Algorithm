import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[8];
            calculate(A, N);
            
            sb.append(String.format("#%d\n%s\n", t, arrayToString(A)));            
        }
        System.out.println(sb);
    }

    public static void calculate(int[] A, int money){
        A[0] = money / 50_000;
        A[1] = (money % 50_000) / 10_000;
        A[2] = (money % 10_000) / 5_000;
        A[3] = (money % 5_000) / 1_000;
        A[4] = (money % 1_000) / 500;
        A[5] = (money % 500) / 100;
        A[6] = (money % 100) / 50;
        A[7] = (money % 50) / 10;
    }

    public static String arrayToString(int[] A){
        StringBuilder sb = new StringBuilder();
        for (int x : A ) {
            sb.append(x).append(" ");
        }
        return sb.toString();
    }
}