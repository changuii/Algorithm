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
        int emptyNum = N-1;
        for(int i=1; i<=2 * N - 1; i += 2){
            sb.append(empty.repeat(emptyNum--) + star.repeat(i)).append("\n");
        }

        emptyNum += 2;
        for(int i=2 * N - 3; i > 0; i -= 2){
            sb.append(empty.repeat(emptyNum++) + star.repeat(i)).append("\n");
        }

        System.out.println(sb);
        
    }
}