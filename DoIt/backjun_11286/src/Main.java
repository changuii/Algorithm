import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2)->{
            int first = Math.abs(o1);
            int second = Math.abs(o2);
            if(first == second) return o1 > o2 ? 1 : -1;
            else return first - second;

        });

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++){
            int c = Integer.parseInt(br.readLine());
            if(c != 0){
                queue.add(c);
            }else if(queue.isEmpty()&&c == 0){
                sb.append(0).append("\n");
            }else if(!queue.isEmpty()&&c == 0){
                sb.append(queue.poll()).append("\n");
            }
        }
        System.out.println(sb);

    }
}