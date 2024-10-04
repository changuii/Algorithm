import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> clazz = new PriorityQueue<>(); 
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2)->{
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]; 
        });

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st= new StringTokenizer(br.readLine());
            q.offer(new int[]{
               Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) 
            });
        }

        clazz.offer(q.poll()[1]);
        while (!q.isEmpty()) {
            int[] now = q.poll();

            if(clazz.peek() <= now[0]){
                clazz.poll();
                clazz.offer(now[1]);
            }
            else{
                clazz.offer(now[1]);
            }
        }

        System.out.println(clazz.size());
        
        
            
    }
}