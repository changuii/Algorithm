import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1, o2) -> {
            return o2 - o1;
        });

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());

            if(now == 0){
                sb.append(q.isEmpty() ? 0 : q.poll()).append("\n");
                continue;
            }

            q.offer(now);
        }

        System.out.println(sb);
    }
        
    
}