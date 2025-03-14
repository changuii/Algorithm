import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int answer = Integer.parseInt(br.readLine());
        while(true){
            String oper = br.readLine();
            
            if(oper.equals("=")) break;
            
            int now = Integer.parseInt(br.readLine());
            
            if(oper.equals("+")){
                answer += now;
            } else if(oper.equals("/")) {
                answer /= now;
            } else if(oper.equals("*")){
                answer *= now;
            } else if(oper.equals("-")){
                answer -= now;
            }
        }
        System.out.println(answer);
    }
}