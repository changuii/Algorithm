import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> positive = new PriorityQueue<>((o1, o2) -> {
           return o2 - o1;
        });

        PriorityQueue<Integer> negative = new PriorityQueue<>((o1, o2) -> {
           int num1 = Math.abs(o1);
           int num2 = Math.abs(o2);

           return num2 - num1;
        });


        int zero = 0;
        for(int i=0; i<N; i++){
            int value = Integer.parseInt(br.readLine());
            if(value > 0) positive.add(value);
            else if(value < 0) negative.add(value);
            else zero++;
        }

        int answer = 0;
        while (positive.size() > 1){
            int x = positive.poll();
            int y = positive.poll();
            if(x+y < x*y) answer += x*y;
            else{
                answer += x;
                answer += y;
            }
        }
        answer += positive.isEmpty() ? 0 : positive.poll();

        // 0은 -끼리 곱하고 남은 값들과 곱해야한다.
        while (negative.size() > 1){
            int x = negative.poll();
            int y = negative.poll();
            answer += x*y;
        }
        answer += negative.isEmpty() || zero > 0 ? 0 : negative.poll();

        System.out.println(answer);




    }
}