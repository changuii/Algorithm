import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] values = br.readLine().toCharArray();

        int[] nums = new int[26];
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Double> q = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for(char v : values){
            if(v >= 'A' && v <= 'Z'){
                q.addLast((double) nums[v - 'A']);
                continue;
            }

            double x = q.pollLast();
            double y = q.pollLast();

            // y를 먼저 하는 이유는 y값이 스택상 앞에 있다.
            if(v == '+'){
                q.addLast(y + x);
            } else if(v == '-'){
                q.addLast(y - x);
            } else if(v == '*'){
                q.addLast(y * x);
            } else if(v == '/'){
                q.addLast(y / x);
            }
        }
        
        System.out.printf("%.2f", q.pollLast());
    }
}