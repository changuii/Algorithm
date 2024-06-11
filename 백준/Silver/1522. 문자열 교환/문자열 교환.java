import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // a bbabbab a 
        char[] value = br.readLine().toCharArray();
        int count = 0;
        for(int i=0; i<value.length; i++){
            if(value[i] == 'a') count++;
        }

        int answer = Integer.MAX_VALUE;
        for(int i=0; i<value.length; i++){
            int c = 0;
            for(int j=i; j<i+count; j++){
                if(value[j % value.length] == 'b') c++;
            }
            answer = Math.min(answer, c);
        }
        System.out.println(answer);
        
        
    }
}