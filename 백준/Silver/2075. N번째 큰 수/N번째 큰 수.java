import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> q = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                q.add(Integer.parseInt(st.nextToken()));
            }
        }

        for(int i=0; i<N-1; i++){
            q.poll();
        }
        System.out.println(q.poll());
        
    }
}