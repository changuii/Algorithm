import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] A = new Node[N];

        for(int i=0; i<N; i++){
            A[i] = new Node(Integer.parseInt(br.readLine()), i);
        }

        Arrays.sort(A);
        int max = 0;
        for(int i=0; i<N; i++){
            int index = A[i].index - i;
            if(max < index) max = index;
        }

        System.out.println(++max);
    }
    static public class Node implements Comparable<Node>{
        int value;
        int index;

        Node(int value, int index){
            super();
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Node o) {
            return this.value - o.value;
        }
    }
}