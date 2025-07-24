import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=N-1; i>=0; i--){
            sb.append(" ".repeat(i)).append("*".repeat(N - i)).append("\n");
        }
        System.out.println(sb);
    }
}