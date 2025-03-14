import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        double x = Double.parseDouble(st.nextToken());
        double y = Double.parseDouble(st.nextToken());
        
        System.out.println((x / y));
    }
}