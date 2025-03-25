import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());


        int t = 0;
        int now = K - 1;
        int max = 8;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            int T = Integer.parseInt(st.nextToken());
            String command = st.nextToken();

            t += T;
            if(t > 210){
                System.out.println(now+1);
                return;
            }

            if(command.equals("T")){
                now = (now + 1) % max;
            } 
        }
    }
}