import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] A = new int[11];
        for(int i=1; i<11; i++){
            A[i] = (i % 2 == 0 ? -1 : 1) * i + A[i-1];
        }
        
        StringBuilder sb = new StringBuilder();
        for(int t=1; t<=T; t++){
            int N = Integer.parseInt(br.readLine());
            sb.append(String.format("#%d %d\n", t, A[N]));            
        }
        System.out.println(sb);
    }
}