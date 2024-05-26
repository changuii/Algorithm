import java.util.*;
import java.lang.*;
import java.io.*;


// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int count = 1;
        int same = 0;
        
        if(N > 0){
            st = new StringTokenizer(br.readLine());
            
            while(st.hasMoreTokens()){
                int now = Integer.parseInt(st.nextToken());
                if(now > M) count++;
                else if(now == M) same++;
                else break;
            }
        }

        System.out.println(count + same <= P ? count : -1);
        
        
        
    }
}