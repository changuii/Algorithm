import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int J = Integer.parseInt(br.readLine());

        int now = 1;
        int answer = 0;
        for(int i=0; i<J; i++){
            int a = Integer.parseInt(br.readLine());

            int range = now + M - 1; 
            if (a < now){
                int v = now - a;
                now -= v;
                answer += v;
            } else if (range < a){
                int v = a - range;
                now += v;
                answer += v;
            }
        }
        
        System.out.println(answer);
        
    }
}