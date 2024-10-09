import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        for(int t=1;t<=T; t++){

            br.readLine();
            st = new StringTokenizer(br.readLine());

            int N = 8;
            Deque<Integer> deque = new ArrayDeque<>();
            
            for(int i=0; i<N; i++){
                deque.addLast(Integer.parseInt(st.nextToken()));
            }

            int val = 0;
            while (true) {
                int now = deque.poll() - (val++ % 5 + 1);
                // System.out.println(now);
                if(now <= 0){
                    deque.addLast(0);
                    break;
                }
                
                deque.addLast(now);
            }
            
            sb.append(String.format("#%d ", t));

            while (!deque.isEmpty()) {
                sb.append(String.format("%d ", deque.poll()));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}