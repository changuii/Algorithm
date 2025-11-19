import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] val = br.readLine().toCharArray();

        int answer = 0;
        for(int i=0; i<val.length; i++) {
            if(answer == 0 && val[i] == ' ') continue;

            if(val[i] != ' ') answer++;
            while (i < val.length && val[i] != ' ') {
                i++;
            }
        }

        System.out.println(answer);
        
        
    }
    
}