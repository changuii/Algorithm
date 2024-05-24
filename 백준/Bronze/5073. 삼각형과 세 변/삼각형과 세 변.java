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
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a + b + c == 0) break;
            
            int max = Math.max(a, Math.max(b, c));
            if(max >= a+b+c-max)
                sb.append("Invalid").append("\n");
            else if((a == b) && (b == c)) 
                sb.append("Equilateral").append("\n");
            else if((a != b) && (b != c) && (c != a))
                sb.append("Scalene").append("\n");
            else{
                sb.append("Isosceles").append("\n");
            }
        }
        System.out.println(sb);
    }
}