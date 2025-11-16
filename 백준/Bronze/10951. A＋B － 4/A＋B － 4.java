import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(br.ready()){
            st = new StringTokenizer(br.readLine());

            sb.append(
                Integer.parseInt(st.nextToken()) +
                Integer.parseInt(st.nextToken())
            ).append("\n");
        }
        System.out.println(sb);
    }
}