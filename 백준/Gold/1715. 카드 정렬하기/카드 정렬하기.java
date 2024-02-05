import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for(int i=0; i<N; i++){
            queue.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while (queue.size() > 1){
            int x = queue.poll();
            int y = queue.poll();
            answer += x + y;
            queue.add(x + y);
        }

        System.out.println(answer);

    }
}