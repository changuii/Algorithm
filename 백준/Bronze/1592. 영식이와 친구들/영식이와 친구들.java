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
        int L = Integer.parseInt(st.nextToken());

        int[] c = new int[N];

        c[0] = 1;
        int now = 0;
        int answer = 0;
        while (true) {
            if(c[now] == M) break;
            
            if(c[now] % 2 ==0){
                now = Math.floorMod(now - L, N);
            } else {
                now = Math.floorMod(now + L, N);
            }
            answer++;
            c[now]++;
        }
        System.out.println(answer);
    }
}