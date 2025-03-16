import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String empty = " ";
        String star = "*";

        StringBuilder sb = new StringBuilder();
        for(int i=N; i>0; i--){
            sb.append(empty.repeat(N - i) + star.repeat(i)).append("\n");
        }

        System.out.println(sb);
        
    }
}