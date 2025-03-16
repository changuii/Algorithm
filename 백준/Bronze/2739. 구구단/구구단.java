import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=9; i++){
            sb.append(String.format("%d * %d = %d\n", N, i, N * i));
        }

        System.out.println(sb);
        
    }
}