import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String val = br.readLine();
        if(val.length() < 2){
            val = "0" + val;
        }

        int c = 1;
        String now = operation(val);
        while (!now.equals(val)) {
            now = operation(now);
            c++;
        }
        System.out.println(c);
    }

    public static String operation(String val){
        int x = val.charAt(0) - '0';
        int y = val.charAt(1) - '0';

        String sum = String.valueOf(x + y);
        if(sum.length() > 1){
            sum = sum.charAt(1) + "";
        }

        return y + "" + sum;
        
    }
}