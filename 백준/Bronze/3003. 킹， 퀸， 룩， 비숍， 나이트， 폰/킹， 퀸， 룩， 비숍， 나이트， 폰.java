import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.time.format.TextStyle;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.println(
            new StringBuilder()
            .append((1 - Integer.parseInt(st.nextToken())))
            .append(" ")
            .append((1 - Integer.parseInt(st.nextToken())))
            .append(" ")
            .append((2 - Integer.parseInt(st.nextToken())))
            .append(" ")
            .append((2 - Integer.parseInt(st.nextToken())))
            .append(" ")
            .append((2 - Integer.parseInt(st.nextToken())))
            .append(" ")
            .append((8 - Integer.parseInt(st.nextToken())))
        );
                
        
    }
}