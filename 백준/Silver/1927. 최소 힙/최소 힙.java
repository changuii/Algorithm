import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> q = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());
            if(now == 0){
                sb.append(!q.isEmpty() ? q.poll() : 0).append("\n");
            }
            else{
                q.add(now);
            }
        }

        System.out.println(sb);
    }
}