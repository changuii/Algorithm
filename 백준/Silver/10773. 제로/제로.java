import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<N; i++){
            int now = Integer.parseInt(br.readLine());

            if(!stack.isEmpty() && now == 0){
                stack.pop();
                continue;
            }
            stack.push(now);
        }
        int answer = 0;
        for(int v : stack){
            answer += v;
        }

        System.out.println(answer);
        
    }
}