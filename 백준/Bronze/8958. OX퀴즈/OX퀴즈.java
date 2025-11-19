import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            char[] val = br.readLine().toCharArray();

            int c = 0;
            int score = 0;
            for(int x=0; x<val.length; x++) {
                if(val[x] == 'O') score += ++c;
                else c = 0;
            }

            sb.append(score).append("\n");
            
        }
        System.out.println(sb);

    }
    
}