import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();

        int answer = 0;
        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());

            st.nextToken();
            int b = Integer.parseInt(st.nextToken());
            
            while(!stack.isEmpty() && stack.peek() > b){
                stack.pop();
                answer++;
            }
            if(!stack.isEmpty() && stack.peek() == b) continue;
            stack.push(b);
        }

        for(int v : stack){
            if(v == 0) continue;
            answer++;
        }

        System.out.println(answer);

        
        
    }
}