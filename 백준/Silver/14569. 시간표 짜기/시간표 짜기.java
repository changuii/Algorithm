import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;

        long[] subjects = new long[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            subjects[i] = 0;
            for(int j=0; j<x; j++){
                int s = Integer.parseInt(st.nextToken());
                subjects[i] = (subjects[i] | (1L << s));
            }
        }

        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());

            long p = 0;
            for(int j=0; j<x; j++){
                p = (p | (1L << Integer.parseInt(st.nextToken())));
            }

            int c = 0;
            for(long s : subjects){
                if((s & p) == s){
                    c++;
                }
            }
            sb.append(c).append("\n");
        }
        System.out.println(sb);
    }
}