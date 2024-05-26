import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        ArrayList<Node> nodes = new ArrayList<>();

        Node target = null;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            Node now = new Node(c,
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));
            if(c == T){
                target = now;
            }else nodes.add(now);
        }
        
        int count = 0;
        for(Node n : nodes){
            if(n.g > target.g){
                count++;
            }else if(n.s > target.s && n.g == target.g){
                count++;
            }else if(n.b > target.b && n.g + n.s == target.g + target.s){
                count++;
            }
        }
        System.out.println(count+1);

        
        
        
    }

    public static class Node{
        int c;
        int g;
        int s;
        int b;
        int th;
        public Node(int c, int g, int s, int b){
            this.c=c;
            this.g=g;
            this.s=s;
            this.b=b;
        }
        
        
    }
}