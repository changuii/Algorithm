import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] values = br.readLine().split(" ");

        int diff = values[1].length() - values[0].length();

        int min = 51;
        for(int i=0; i<diff+1; i++){
            String a = values[0];
            String b = values[1].substring(i, i + a.length());

            min = Math.min(min, calculate(a, b));
        }

        System.out.println(min);

        
    }

    public static int calculate(String a, String b){

        int c = 0;
        for(int i=0; i<a.length(); i++){
            if(a.charAt(i) != b.charAt(i)){
                c++;
            }
        }
        return c;
    }
}