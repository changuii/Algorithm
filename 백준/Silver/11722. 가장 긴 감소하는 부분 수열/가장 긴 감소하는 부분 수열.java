import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] value;
    static int max = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        value = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        int[] tails = new int[N];
        int len = 0;

        for(int x : value) {
            int y = -x;
            int pos = Arrays.binarySearch(tails, 0, len, y);
            if(pos < 0) pos = -pos - 1;
            tails[pos] = y;
            if(pos == len) len ++;
        }

        System.out.println(len);
        
    }

}