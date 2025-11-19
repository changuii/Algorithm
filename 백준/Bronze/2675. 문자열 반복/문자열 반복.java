import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            String val = st.nextToken();

            for(int i=0; i<val.length(); i++) {
                sb.append(val.substring(i, i+1).repeat(N));
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
    
}