import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(true){
            st = new StringTokenizer(br.readLine());

            int val =Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()); 

            if(val == 0)break;
            
            sb.append(val).append("\n");
        }
        System.out.println(sb);
    }
}