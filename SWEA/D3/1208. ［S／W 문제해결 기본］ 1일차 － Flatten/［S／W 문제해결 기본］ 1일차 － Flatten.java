import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Solution {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t =1; true; t++){

            String oper = br.readLine();
            if(oper == null) break;
            
            int N = 100;
            int M = Integer.parseInt(oper);

            st = new StringTokenizer(br.readLine());
            PriorityQueue<Node> max = new PriorityQueue<>((o1, o2) ->{
               return o2.h-o1.h; 
            });
            PriorityQueue<Node> min = new PriorityQueue<>((o1, o2) ->{
                return o1.h-o2.h;
            });

            for(int i=0; i<N; i++){
                Node n = new Node(Integer.parseInt(st.nextToken()));
                max.offer(n);
                min.offer(n);
            }

            for(int i=0; i<M; i++){
                Node n1 = max.poll();
                Node n2 = min.poll();

                n1.h -= 1;
                n2.h += 1;

                max.offer(n1);
                min.offer(n2);
            }
            
            sb.append("#").append(t).append(" ")
                .append(max.peek().h - min.peek().h).append("\n");
        }
        System.out.println(sb);
    }
        
    public static class Node{
        int h;
        public Node(int h){
            this.h=h;
        }

    }
    
}