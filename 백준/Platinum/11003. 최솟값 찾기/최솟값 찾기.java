import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

       Deque<Node> q = new LinkedList<>();

        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(st.nextToken());

            while(!q.isEmpty() && q.getLast().value > now){
                q.removeLast();
            }
            q.addLast(new Node(now, i));

            while(!q.isEmpty() && q.getFirst().index < i-M+1){
                q.removeFirst();
            }
            sb.append(q.getFirst().value).append(" ");
        }
        
        
        System.out.println(sb);
    }
        
        static class Node{
        int value;
        int index;

        public Node(int value, int index){
            this.value = value;
            this.index = index;
        
    }
    }
}
