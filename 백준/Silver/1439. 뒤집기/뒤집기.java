import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String sb = br.readLine();

        int c1 = 0;
        int c2 = 0;
        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '1'){
                c1++;
                for(int j=i; j<sb.length(); j++){
                    if(sb.charAt(i) == '0') break;

                    i++;
                }
            }

        }

        for(int i=0; i<sb.length(); i++){
            if(sb.charAt(i) == '0'){
                c2++;
                for(int j=i; j<sb.length(); j++){
                    if(sb.charAt(i) == '1') break;

                    i++;
                }
            }
        }

        System.out.println(c1 < c2 ? c1 : c2);

        
            
    }
}