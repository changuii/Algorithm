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

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int max = -1_000_001;
        int min = 1_000_001;
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            max = Math.max(max, now);
            min = Math.min(min, now);
        }

        System.out.printf("%d %d", min, max);

    }
}