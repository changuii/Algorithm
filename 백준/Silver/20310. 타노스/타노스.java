import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        String zero = x.replace("1", "");
        String one = x.replace("0", "");

        
        zero = zero.substring(0, zero.length() / 2);
        one = one.substring(0, one.length() / 2);

        System.out.println(zero + one);
        
    }
}