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

        PriorityQueue<Long> q = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        long sum = 0;
        for(int i=0; i<N; i++){
            long val = Long.parseLong(st.nextToken());
            q.offer(val);
            sum += val;
        }

        while (M > 0){
            M--;

            long val1 = q.poll();
            long val2 = q.poll();
            sum -= val1;
            sum -= val2;

            val1 += val2;
            val2 = val1;
            sum += val1 * 2;

            q.offer(val1);
            q.offer(val2);
        }

        System.out.println(sum);
        

        
        
    }
}