import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String value = br.readLine();
        

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=value.length(); i++){
            if(i % 10 == 0){
                sb.append(value.charAt(i-1)+"\n");
                continue;
            }
            sb.append(value.charAt(i-1));
        }

        System.out.println(sb);
        
    }
}