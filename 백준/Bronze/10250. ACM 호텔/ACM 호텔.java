import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<List<Integer>> list;
    static int[] time;
    static int[] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<T; t++ ){
            st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int w = ((N - 1) / H) + 1;
            int h = ((N - 1) % H) + 1;

            sb.append(
                String.format("%d%02d", h, w)
            ).append("\n");
            
        }

        System.out.println(sb);
    }
}